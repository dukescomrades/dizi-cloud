package com.dizi.dz.repository;

import com.dizi.dz.entity.Dizi;
import com.dizi.dz.entity.DiziOrder;
import com.dizi.dz.entity.IngredientRef;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public DiziOrder save(DiziOrder order) {
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Dizi_Order "
                                + "(delivery_name, delivery_street, delivery_city, "
                                + "delivery_state, delivery_zip, cc_number, "
                                + "cc_expiration, cc_cvv, placed_at) "
                                + "values (?,?,?,?,?,?,?,?,?)",
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
                );
        pscf.setReturnGeneratedKeys(true);
        order.setPlacedAt(new Date());
        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                order.getDeliveryName(),
                                order.getDeliveryStreet(),
                                order.getDeliveryCity(),
                                order.getDeliveryState(),
                                order.getDeliveryZip(),
                                order.getCcNumber(),
                                order.getCcExpiration(),
                                order.getCcCVV(),
                                order.getPlacedAt()));
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);
        List<Dizi> dizis = order.getDz();
        int i = 0;
        for (Dizi dizi : dizis) {
            saveDizi(orderId, i++, dizi);
        }
        return order;
    }

    private long saveDizi(Long orderId, int orderKey, Dizi dizi) {
        dizi.setCreatedAt(new Date());
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Dizi "
                                + "(name, created_at, dizi_order, dizi_order_key) "
                                + "values (?, ?, ?, ?)",
                        Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
                );
        pscf.setReturnGeneratedKeys(true);
        PreparedStatementCreator psc =
                pscf.newPreparedStatementCreator(
                        Arrays.asList(
                                dizi.getName(),
                                dizi.getCreatedAt(),
                                orderId,
                                orderKey));
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long diziId = keyHolder.getKey().longValue();
        dizi.setId(diziId);
        saveIngredientRefs(diziId, dizi.getIngredients());
        return diziId;
    }

    private void saveIngredientRefs(long diziId, List<IngredientRef> ingredientRefs) {
        int key = 0;
        for (IngredientRef ingredientRef : ingredientRefs) {
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, dizi, dizi_key) "
                            + "values (?, ?, ?)",
                    ingredientRef.getIngredient(), diziId, key++);
        }
    }

}


