create USER liquibase_user with PASSWORD 'liquibase_password';

create DATABASE currency_rate_db ENCODING 'UTF-8';

grant all privileges on DATABASE currency_rate_db TO liquibase_user;
