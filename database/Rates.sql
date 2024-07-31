START TRANSACTION;

CREATE TABLE Rates (
    id serial PRIMARY KEY,
    short_name varchar(32) NOT NULL,
    valid_from varchar(32) NOT NULL,
    name varchar(32) NOT NULL,
    country varchar(64) NOT NULL,
    move decimal NOT NULL,
    amount smallint NOT NULL,
    val_buy decimal NOT NULL,
    val_sell decimal NOT NULL,
    val_mid decimal NOT NULL,
    curr_buy decimal NOT NULL,
    curr_sell decimal NOT NULL,
    curr_mid decimal NOT NULL,
    version smallint NOT NULL,
    cnb_mid decimal NOT NULL,
    ecb_mid decimal NOT NULL
);

COMMIT;