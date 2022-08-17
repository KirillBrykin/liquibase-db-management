create table liquibase_user_role(
    id      int8 not null,
    name    varchar(255),
    user_id int8,
    primary key (id)
)
GO

alter table if exists liquibase_user_role
    add constraint FKqs24l3gc2pk9jc3mqyjiq281b
    foreign key (user_id)
    references liquibase_user
GO