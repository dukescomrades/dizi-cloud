CREATE TABLE IF NOT EXISTS Dizi_Order
(
    id
    IDENTITY
    PRIMARY
    KEY,
    delivery_Name
    VARCHAR
(
    250
) NOT NULL,
    delivery_Street VARCHAR
(
    250
) NOT NULL,
    delivery_City VARCHAR
(
    250
) NOT NULL,
    delivery_State VARCHAR
(
    250
) NOT NULL,
    delivery_Zip VARCHAR
(
    10
) NOT NULL,
    cc_number VARCHAR
(
    16
) NOT NULL,
    cc_expiration VARCHAR
(
    5
) NOT NULL,
    cc_cvv VARCHAR
(
    3
) NOT NULL,
    placed_at TIMESTAMP NOT NULL
    );

CREATE TABLE IF NOT EXISTS Ingredient
(
    id
    VARCHAR
(
    250
) PRIMARY KEY,
    name VARCHAR
(
    250
) NOT NULL,
    type VARCHAR
(
    250
) NOT NULL
    );

CREATE TABLE IF NOT EXISTS Dizi
(
    id
    IDENTITY
    PRIMARY
    KEY,
    name
    VARCHAR
(
    250
) NOT NULL,
    dizi_order BIGINT NOT NULL,
    dizi_order_key BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY
(
    dizi_order
) REFERENCES Dizi_Order
(
    id
)
    );

CREATE TABLE IF NOT EXISTS Ingredient_Ref
(
    ingredient
    VARCHAR
(
    250
) NOT NULL,
    dizi BIGINT NOT NULL,
    dizi_key BIGINT NOT NULL,
    FOREIGN KEY
(
    ingredient
) REFERENCES Ingredient
(
    id
)
    );