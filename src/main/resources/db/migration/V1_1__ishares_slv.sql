CREATE TABLE ishares_slv (
    id serial primary key,
    date date not null,
    index_level numeric not null,
    nav_per_share numeric not null,
    ex_dividends numeric,
    shares_outstanding numeric not null
);

CREATE UNIQUE INDEX ishares_slv_date_unique_index ON ishares_slv(date);
