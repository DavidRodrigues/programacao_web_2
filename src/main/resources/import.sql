insert into editoras (nome, descricao) values ('Artmed','livros técnicos');
insert into editoras (nome, descricao) values ('Abril','livros gerais');

insert into categorias (nome) values ('Educacao');
insert into categorias (nome) values ('Drama');
insert into categorias (nome) values ('Terror');

insert into livros (isbn, nome, categoria_id, editora_id) values ('1', 'Java Web', 1, 1);
insert into livros (isbn, nome, categoria_id, editora_id) values ('2', 'Metamorfose', 2, 2);
insert into livros (isbn, nome, categoria_id, editora_id) values ('teste', 'O velho e o mar', 2, 2);
insert into livros (isbn, nome, categoria_id, editora_id) values ('asdf', 'O mítico homem-mês', 1, 1);

insert into perfil (nome, descricao) values ('ROLE_ADMIN', 'Perfil de administrador');
insert into perfil (nome, descricao) values ('ROLE_USER', 'Perfil de usuário comum');



