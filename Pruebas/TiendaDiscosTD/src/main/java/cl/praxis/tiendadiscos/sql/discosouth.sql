create schema discos_south_db;
use discos_south_db;


create table sucursal(
                         sucursal_id int auto_increment primary key,
                         sucursal_descripcion varchar(50) not null
);
create table tipo_membresia(
                               tipo_membresia_id int auto_increment primary key,
                               tipo_membresia_descripcion varchar(50) not null
);
create table genero(
                       genero_id int auto_increment primary key,
                       genero_descripcion varchar(50) not null
);

create table miembro(
                        miembro_id int auto_increment primary key,
                        miembro_nombre varchar(50) not null,
                        miembro_apellidos varchar(100) not null,
                        miembro_email varchar(100) not null,
                        miembro_fecha_nacimiento date not null,
                        tipo_membresia_id int not null,
                        genero_id int not null,
                        foreign key (genero_id)
                            references  genero (genero_id),
                        foreign key (tipo_membresia_id)
                            references  tipo_membresia (tipo_membresia_id)
);

create table disco(
                      disco_id int auto_increment primary key,
                      disco_nombre_artista varchar(100) not null,
                      disco_titulo varchar(200) not null,
                      disco_duracion varchar(50) not null,
                      disco_genero_musical varchar(50) not null,
                      disco_compania varchar(50) not null,
                      disco_stock int not null,
                      disco_precio int not null
);
create table venta_miembro(
                              venta_miembro_id int auto_increment primary key,
                              miembro_id int not null,
                              disco_id int not null,
                              venta_miembro_cantidad int not null,
                              sucursal_id int not null,
                              foreign key (miembro_id)
                                  references  miembro (miembro_id),
                              foreign key (disco_id)
                                  references  disco (disco_id),
                              foreign key (sucursal_id)
                                  references  sucursal (sucursal_id)
);

create table vendedor(
                         vendedor_id  int auto_increment primary key,
                         vendedor_nombre varchar(50) not null,
                         vendedor_apellidos varchar(100) not null,
                         sucursal_id int not null,
                         foreign key (sucursal_id)
                             references  sucursal (sucursal_id)
);


-- inserts
insert into sucursal (sucursal_descripcion)
    value ('Casa Matriz'),('El Llano');
insert into tipo_membresia (tipo_membresia_descripcion)
    value ('Vinil I'),('Vinil II'),('Vinil III');
insert into genero (genero_descripcion)
    value ('Feminino'),('Masculino');

insert into miembro (miembro_nombre, miembro_apellidos, miembro_email, miembro_fecha_nacimiento, tipo_membresia_id, genero_id) values
                                                                                                                                   ('Dulcie'   , 'Uphill'     , 'duphill0@typepad.com'              , '1985-01-13',  2, 2),
                                                                                                                                   ('Renard'   , 'Tegeller'   , 'rtegeller1@seattletimes.com'       , '1968-07-15',  2, 1),
                                                                                                                                   ('Etti'     , 'Ecob'       , 'eecob2@stanford.edu'               , '1971-12-30',  1, 1),
                                                                                                                                   ('Marcie'   , 'Nestoruk'   , 'mnestoruk3@narod.ru'               , '1970-07-09',  1, 2),
                                                                                                                                   ('Ericka'   , 'Band'       , 'eband4@google.com.au'              , '1986-05-14',  1, 2),
                                                                                                                                   ('Pier'     , 'Minthorpe'  , 'pminthorpe5@sohu.com'              , '1991-04-03',  3, 1),
                                                                                                                                   ('Aldon'    , 'Drieu'      , 'adrieu6@hubpages.com'              , '1966-03-09',  2, 1),
                                                                                                                                   ('Rhiamon'  , 'Rennick'    , 'rrennick7@uol.com.br'              , '1980-05-29',  2, 2),
                                                                                                                                   ('Giffy'    , 'Corington'  , 'gcorington8@ustream.tv'            , '1979-01-25',  3, 2),
                                                                                                                                   ('Valli'    , 'Le - Count' , 'vlecount9@bbc.co.uk'               , '1967-09-13',  2, 2),
                                                                                                                                   ('Caril'    , 'Borrell'    , 'cborrella@t.co'                    , '1978-05-05',  2, 1),
                                                                                                                                   ('Penny'    , 'Eccleshare' , 'peccleshareb@businesswire.com'     , '1981-03-19',  2, 1),
                                                                                                                                   ('Hilda'    , 'O''Towey'   , 'hotoweyc@home.pl'                  , '1994-08-08',  1, 1),
                                                                                                                                   ('Meir'     , 'Cropton'    , 'mcroptond@webmd.com'               , '1978-06-08',  3, 2),
                                                                                                                                   ('Krystle'  , 'Broschek'   , 'kbroscheke@fema.gov'               , '1974-03-11',  2, 2),
                                                                                                                                   ('Bing'     , 'Haseley'    , 'bhaseleyf@dyndns.org'              , '2000-09-27',  2, 1),
                                                                                                                                   ('Merola'   , 'Laurenceau' , 'mlaurenceaug@dagondesign.com'      , '1969-02-16',  1, 1),
                                                                                                                                   ('Jim'      , 'Naish'      , 'jnaishh@jalbum.net'                , '1994-11-15',  3, 2),
                                                                                                                                   ('Arleta'   , 'MacAllaster', 'amacallasteri@tmall.com'           , '1996-07-13',  3, 2),
                                                                                                                                   ('Millicent', 'Wibrew'     , 'mwibrewj@bing.com'                 , '1978-08-21',  1, 2),
                                                                                                                                   ('Katrina'  , 'Roadknight' , 'kroadknightk@xinhuanet.com'        , '2003-03-23',  1, 2),
                                                                                                                                   ('Arley'    , 'Priestnall' , 'apriestnalll@linkedin.com'         , '1989-02-26',  2, 1),
                                                                                                                                   ('Grange'   , 'Caron'	   , 'gcaronm@cnn.com'                   , '1970-06-06',  1, 2),
                                                                                                                                   ('Janenna'  , 'Challin'    , 'jchallinn@hexun.com'               , '1986-07-30',  2, 2),
                                                                                                                                   ('Juliana'  , 'Bealing'    , 'jbealingo@fc2.com'                 , '1993-11-27',  3, 2);

insert into disco (disco_nombre_artista, disco_titulo, disco_duracion, disco_genero_musical, disco_compania, disco_stock,disco_precio) values
                                                                                                                                           ('Layton Constantine', 'Eleocharis occulta S.G. Sm.', 90, 'pop', 'Edgetag', 9,12000),
                                                                                                                                           ('Goldi Haddow', 'Carex digitalis Willd. var. macropoda Fernald', 90, 'classical', 'Oyonder', 21,13000),
                                                                                                                                           ('Bat Briston', 'Bryum archangelicum Bruch & Schimp.', 39, 'jazz', 'Digitube', 23,15000),
                                                                                                                                           ('Felisha Thews', 'Leandra krugii (Cogn.) W.S. Judd & Skean', 130, 'hip hop', 'Mymm', 15,12500),
                                                                                                                                           ('Davey Dourin', 'Senecio magnificus F. Muell.', 62, 'rock', 'Meevee', 20,13000),
                                                                                                                                           ('Maurine Searson', 'Rhabdadenia Müll. Arg.', 469, 'pop', 'Pixoboo', 20,14000),
                                                                                                                                           ('Jenni Riddle', 'Sibbaldia L.', 478, 'pop', 'Youopia', 13,12990),
                                                                                                                                           ('Lawry Fust', 'Delphinium gypsophilum Ewan', 439, 'classical', 'Fliptune', 13,15000),
                                                                                                                                           ('Bee Franckton', 'Mimosa quadrivalvis L. var. nelsonii (Britton & Rose) Barneby', 578, 'jazz', 'Innotype', 7,9000),
                                                                                                                                           ('Rafael Ferreras', 'Ptychomitrium incurvum (Schwägr.) Spruce', 469, 'pop', 'Twimbo', 6,11000),
                                                                                                                                           ('Tansy Schimek', 'Sisyrinchium tracyi E.P. Bicknell', 271, 'pop', 'Flipstorm', 3,13000),
                                                                                                                                           ('Dulcy McLleese', 'Rhizocarpon polycarpoides Degel.', 200, 'jazz', 'Linktype', 15,10000),
                                                                                                                                           ('Clifford Selland', 'Muhlenbergia filiformis (Thurb. ex S. Watson) Rydb.', 509, 'rock', 'Skaboo', 2,12000),
                                                                                                                                           ('Harland Dummer', 'Quercus parvula Greene var. parvula', 455, 'classical', 'Buzzshare', 5,11000),
                                                                                                                                           ('Rosemonde Setch', 'Salix lucida Muhl. ssp. caudata (Nutt.) A.E. Murray', 345, 'pop', 'Centizu', 16,13000),
                                                                                                                                           ('Bernard Gohn', 'Pellaea glabella Mett. ex Kuhn ssp. glabella', 368, 'rock', 'Talane', 9,16000),
                                                                                                                                           ('Dorine Vasilic', 'Pseudoleskea baileyi Best & Grout', 518, 'jazz', 'Jamia', 22,14000),
                                                                                                                                           ('Neal Marriner', 'Corydalis micrantha (Engelm. ex A. Gray) A. Gray', 321, 'rock', 'BlogXS', 14,16000),
                                                                                                                                           ('Meier Trevethan', 'Arctostaphylos ×laxiflora A. Heller (pro sp.)', 345, 'hip hop', 'Bubblemix', 12,18000),
                                                                                                                                           ('Kleon Berntsson', 'Collema tenax (Sw.) Ach. var. crustaceum (Krempelh.) Degel.', 412, 'hip hop', 'Voonyx', 2,10000);

insert into vendedor (vendedor_nombre, vendedor_apellidos, sucursal_id)
values ('Creigh', 'McReynold', 1),
       ('Reba', 'Tompsett', 2),
       ('Dav', 'Montague', 2),
       ('Anni', 'Clougher', 1),
       ('Halie', 'Carrabott', 1),
       ('Tam', 'Clemitt', 1);

insert into venta_miembro (miembro_id, disco_id, venta_miembro_cantidad,sucursal_id)
values (20,15, 2,2),
       (11,3,2,2),
       (14,13,3,2),
       (5,16,1,1),
       (17,4,3,2),
       (2,2,2,1),
       (16,2,3,1),
       (16,9,1,2),
       (2,15,2,1),
       (18,9,3,2),
       (8,1,2,1),
       (19,9,3,2),
       (10,3,1,1),
       (25,15,2,2),
       (22,20,1,1),
       (5,14,1,2),
       (5,17,3,1),
       (20,6,2,1),
       (19,11,1,2),
       (7,5,3,2),
       (14,2,1,2),
       (17,20,3,2),
       (22,14,1,1),
       (15,13,1,1),
       (11,2,1,2),
       (4,11,3,2),
       (11,13,2,1),
       (3,17,3,1),
       (17,11,3,1),
       (3,2,1,2),
       (25,14,3,2),
       (24,17,1,1),
       (2,8,3,1),
       (19,17,1,1),
       (2,6,2,2),
       (19,7,3,2),
       (5,1,3,2),
       (10,2,3,2),
       (7,6,1,1),
       (25,14,3,2),
       (2,1,1,1),
       (20,9,1,2),
       (22,7,1,1),
       (18,3,1,2),
       (21,10,3,2),
       (1,3,2,2),
       (20,8,3,2),
       (14,3,2,2),
       (17,13,1,2),
       (17,15,1,2),
       (25,6,1,2),
       (16,13,3,2),
       (15,4,1,2),
       (9,20,1,1),
       (20,9,2,1),
       (18,4,2,1),
       (3,17,3,2),
       (2,6,2,2),
       (17,14,1,2),
       (8,1,2,1),
       (7,13,2,2),
       (1,16,3,1),
       (9,14,1,2),
       (18,9,3,2),
       (17,11,2,2),
       (24,6,2,2),
       (3,16,1,2),
       (8,12,3,2),
       (2,6,2,2),
       (25,9,2,2),
       (17,13,2,2),
       (21,2,3,2),
       (25,3,2,2),
       (5,12,2,2),
       (1,10,3,1),
       (12,19,2,1),
       (12,1,2,1),
       (7,19,2,2),
       (9,10,3,2),
       (10,15,3,1),
       (20,8,1,1),
       (12,18,3,2),
       (9,18,2,2),
       (2,15,1,1),
       (11,2,2,2),
       (20,12,2,1),
       (10,12,3,2),
       (11,10,1,2),
       (21,10,2,1),
       (15,6,2,2),
       (14,15,3,2),
       (12,7,1,2),
       (14,20,3,1),
       (15,12,2,2),
       (2,7,2,2),
       (11,1,1,2),
       (3,9,3,1),
       (17,8,1,2),
       (14,5,1,1),
       (15,8,3,2);
