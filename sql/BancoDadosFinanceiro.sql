/*==============================================================*/
/* DBMS name:      Sybase AS Anywhere 9                         */
/* Created on:     27/5/2009 22:36:04                           */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_TIPODOCU') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_TIPODOCU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_FORNECED') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_FORNECED
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_MOVIMENT') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_MOVIMENT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_CONTACOR') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_CONTACOR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_CENTROCU') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_CENTROCU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_BANCOS') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_BANCOS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_FORMAPAG') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_FORMAPAG
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_CONTAS_RELATIONS_EMPRESA') then
    alter table CONTAS
       delete foreign key FK_CONTAS_RELATIONS_EMPRESA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_EMPRESA_RELATIONS_CIDADES') then
    alter table EMPRESA
       delete foreign key FK_EMPRESA_RELATIONS_CIDADES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_FILIAL_RELATIONS_EMPRESA') then
    alter table FILIAL
       delete foreign key FK_FILIAL_RELATIONS_EMPRESA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_FORNECED_RELATIONS_TIPOCLIE') then
    alter table FORNECEDORCLIENTE
       delete foreign key FK_FORNECED_RELATIONS_TIPOCLIE
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_FORNECED_RELATIONS_CIDADES') then
    alter table FORNECEDORCLIENTE
       delete foreign key FK_FORNECED_RELATIONS_CIDADES
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MOVIMENT_RELATIONS_CONTACOR') then
    alter table MOVIMENTACAOFINANCEIRA
       delete foreign key FK_MOVIMENT_RELATIONS_CONTACOR
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MOVIMENT_RELATIONS_BANCOS') then
    alter table MOVIMENTACAOFINANCEIRA
       delete foreign key FK_MOVIMENT_RELATIONS_BANCOS
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MOVIMENT_RELATIONS_CENTROCU') then
    alter table MOVIMENTACAOFINANCEIRA
       delete foreign key FK_MOVIMENT_RELATIONS_CENTROCU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MOVIMENT_RELATIONS_FORNECED') then
    alter table MOVIMENTACAOFINANCEIRA
       delete foreign key FK_MOVIMENT_RELATIONS_FORNECED
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_MOVIMENT_RELATIONS_EMPRESA') then
    alter table MOVIMENTACAOFINANCEIRA
       delete foreign key FK_MOVIMENT_RELATIONS_EMPRESA
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_USUARIO_RELATIONS_CIDADES') then
    alter table USUARIO
       delete foreign key FK_USUARIO_RELATIONS_CIDADES
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='BANCOS_PK'
     and t.table_name='BANCOS'
) then
   drop index BANCOS.BANCOS_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CENTROCUSTOS_PK'
     and t.table_name='CENTROCUSTOS'
) then
   drop index CENTROCUSTOS.CENTROCUSTOS_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CIDADES_PK'
     and t.table_name='CIDADES'
) then
   drop index CIDADES.CIDADES_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CONTACORRENTE_PK'
     and t.table_name='CONTACORRENTE'
) then
   drop index CONTACORRENTE.CONTACORRENTE_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='CONTAS_PK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.CONTAS_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_10_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_10_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_15_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_15_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_2_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_2_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_3_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_3_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_4_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_4_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_5_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_5_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_6_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_6_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_7_FK'
     and t.table_name='CONTAS'
) then
   drop index CONTAS.RELATIONSHIP_7_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='EMPRESA_PK'
     and t.table_name='EMPRESA'
) then
   drop index EMPRESA.EMPRESA_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_8_FK'
     and t.table_name='EMPRESA'
) then
   drop index EMPRESA.RELATIONSHIP_8_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_16_FK'
     and t.table_name='FILIAL'
) then
   drop index FILIAL.RELATIONSHIP_16_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='FORMAPAGAMENTO_PK'
     and t.table_name='FORMAPAGAMENTO'
) then
   drop index FORMAPAGAMENTO.FORMAPAGAMENTO_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='FORNECEDORCLIENTE_PK'
     and t.table_name='FORNECEDORCLIENTE'
) then
   drop index FORNECEDORCLIENTE.FORNECEDORCLIENTE_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_11_FK'
     and t.table_name='FORNECEDORCLIENTE'
) then
   drop index FORNECEDORCLIENTE.RELATIONSHIP_11_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_12_FK'
     and t.table_name='FORNECEDORCLIENTE'
) then
   drop index FORNECEDORCLIENTE.RELATIONSHIP_12_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='MOVIMENTACAOFINANCEIRA_PK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.MOVIMENTACAOFINANCEIRA_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_13_FK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.RELATIONSHIP_13_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_14_FK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.RELATIONSHIP_14_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_17_FK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.RELATIONSHIP_17_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_18_FK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.RELATIONSHIP_18_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_1_FK'
     and t.table_name='MOVIMENTACAOFINANCEIRA'
) then
   drop index MOVIMENTACAOFINANCEIRA.RELATIONSHIP_1_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='TIPOCLIENTE_PK'
     and t.table_name='TIPOCLIENTE'
) then
   drop index TIPOCLIENTE.TIPOCLIENTE_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='TIPODOCUMENTO_PK'
     and t.table_name='TIPODOCUMENTO'
) then
   drop index TIPODOCUMENTO.TIPODOCUMENTO_PK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='RELATIONSHIP_9_FK'
     and t.table_name='USUARIO'
) then
   drop index USUARIO.RELATIONSHIP_9_FK
end if;

if exists(
   select 1 from sys.sysindex i, sys.systable t
   where i.table_id=t.table_id 
     and i.index_name='USUARIO_PK'
     and t.table_name='USUARIO'
) then
   drop index USUARIO.USUARIO_PK
end if;

if exists(
   select 1 from sys.systable 
   where table_name='BANCOS'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table BANCOS
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CENTROCUSTOS'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CENTROCUSTOS
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CIDADES'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CIDADES
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CONTACORRENTE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CONTACORRENTE
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CONTAS'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CONTAS
end if;

if exists(
   select 1 from sys.systable 
   where table_name='EMPRESA'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table EMPRESA
end if;

if exists(
   select 1 from sys.systable 
   where table_name='FILIAL'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table FILIAL
end if;

if exists(
   select 1 from sys.systable 
   where table_name='FORMAPAGAMENTO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table FORMAPAGAMENTO
end if;

if exists(
   select 1 from sys.systable 
   where table_name='FORNECEDORCLIENTE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table FORNECEDORCLIENTE
end if;

if exists(
   select 1 from sys.systable 
   where table_name='MOVIMENTACAOFINANCEIRA'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table MOVIMENTACAOFINANCEIRA
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TIPOCLIENTE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TIPOCLIENTE
end if;

if exists(
   select 1 from sys.systable 
   where table_name='TIPODOCUMENTO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table TIPODOCUMENTO
end if;

if exists(
   select 1 from sys.systable 
   where table_name='USUARIO'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table USUARIO
end if;

/*==============================================================*/
/* Table: BANCOS                                                */
/*==============================================================*/
create table BANCOS 
(
    NUMBANCO             varchar(5)                     not null,
    DESCRICAO            varchar(50),
    constraint PK_BANCOS primary key (NUMBANCO)
);

/*==============================================================*/
/* Index: BANCOS_PK                                             */
/*==============================================================*/
create unique index BANCOS_PK on BANCOS (
NUMBANCO ASC
);

/*==============================================================*/
/* Table: CENTROCUSTOS                                          */
/*==============================================================*/
create table CENTROCUSTOS 
(
    CODCENTROCUSTO       integer                        not null default autoincrement,
    DESCRICAOCENTROCUSTO varchar(50),
    CODIGOCENTROCUSTO    varchar(16),
    constraint PK_CENTROCUSTOS primary key (CODCENTROCUSTO)
);

/*==============================================================*/
/* Index: CENTROCUSTOS_PK                                       */
/*==============================================================*/
create unique index CENTROCUSTOS_PK on CENTROCUSTOS (
CODCENTROCUSTO ASC
);

/*==============================================================*/
/* Table: CIDADES                                               */
/*==============================================================*/
create table CIDADES 
(
    MUNICIPIO            varchar(10)                    not null,
    UF                   varchar(2),
    DESCRICAO            varchar(50),
    constraint PK_CIDADES primary key (MUNICIPIO)
);

/*==============================================================*/
/* Index: CIDADES_PK                                            */
/*==============================================================*/
create unique index CIDADES_PK on CIDADES (
MUNICIPIO ASC
);

/*==============================================================*/
/* Table: CONTACORRENTE                                         */
/*==============================================================*/
create table CONTACORRENTE 
(
    CODCONTACORRENTE     integer                        not null default autoincrement,
    DESCRICAO            varchar(50),
    AGENCIA              varchar(30),
    NUMEROCONTACORRENTE  integer,
    SALDOINICIAL         numeric(14,3),
    ATIVAINATIVA         smallint,
    constraint PK_CONTACORRENTE primary key (CODCONTACORRENTE)
);

/*==============================================================*/
/* Index: CONTACORRENTE_PK                                      */
/*==============================================================*/
create unique index CONTACORRENTE_PK on CONTACORRENTE (
CODCONTACORRENTE ASC
);

/*==============================================================*/
/* Table: CONTAS                                                */
/*==============================================================*/
create table CONTAS 
(
    CODCONTAS            integer                        not null default autoincrement,
    CODEMPRESA           integer,
    CODMOVIMENTACAOFINANCEIRA integer,
    CODFORNECEDORCLIENTE integer,
    NUMBANCO             varchar(5),
    CODFORMAPAGAMENTO    integer,
    CODTIPODOCUMENTO     integer,
    CODCENTROCUSTO       integer,
    CODCONTACORRENTE     integer,
    NUMERODOCUMENTO      varchar(50),
    STATUS               varchar(2),
    AGENCIA              varchar(30),
    SITUACAODOCUMENTO    varchar(2),
    DIASPROTESTO         varchar(4),
    DATAEMISSAO          date,
    DATAVENCIMENTO       date,
    VALOR                numeric(14,3),
    NUMERONOTAFISCAL     varchar(50),
    VALORNOTAFISCAL      numeric(14,3),
    NUMEROBOLETO         varchar(50),
    VALORPAGO            numeric(14,3),
    DATALIQUIDACAO       date,
    HISTORICO            varchar(50),
    NUMEROCHEQUE         varchar(8),
    TIPOCONTA            char(1),
    constraint PK_CONTAS primary key (CODCONTAS)
);

/*==============================================================*/
/* Index: CONTAS_PK                                             */
/*==============================================================*/
create unique index CONTAS_PK on CONTAS (
CODCONTAS ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on CONTAS (
CODMOVIMENTACAOFINANCEIRA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on CONTAS (
CODCONTACORRENTE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on CONTAS (
CODCENTROCUSTO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on CONTAS (
NUMBANCO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on CONTAS (
CODFORMAPAGAMENTO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on CONTAS (
CODEMPRESA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on CONTAS (
CODTIPODOCUMENTO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_15_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_15_FK on CONTAS (
CODFORNECEDORCLIENTE ASC
);

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA 
(
    CODEMPRESA           integer                        not null default autoincrement,
    MUNICIPIO            varchar(10),
    RAZAOSOCIAL          varchar(50),
    NOMEFANTASIA         varchar(50),
    PORTEEMPRESA         varchar(50),
    RAMOATIVIDADE        varchar(50),
    HOMEPAGE             varchar(50),
    constraint PK_EMPRESA primary key (CODEMPRESA)
);

/*==============================================================*/
/* Index: EMPRESA_PK                                            */
/*==============================================================*/
create unique index EMPRESA_PK on EMPRESA (
CODEMPRESA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on EMPRESA (
MUNICIPIO ASC
);

/*==============================================================*/
/* Table: FILIAL                                                */
/*==============================================================*/
create table FILIAL 
(
    CODEMPRESA           integer,
    CNPJ                 varchar(15),
    INSCRICAOESTADUAL    varchar(15),
    INSCRICAOMUNICIPAL   varchar(50),
    LOGRADOURO           varchar(50),
    COMPLEMENTO          varchar(50),
    NUMERO               varchar(50),
    BAIRRO               varchar(50),
    REGISTROJUNTACOMERCIAL varchar(50),
    EMAIL                varchar(50),
    TELEFONE             varchar(16),
    FAX                  varchar(16),
    CONTATO              varchar(50)
);

/*==============================================================*/
/* Index: RELATIONSHIP_16_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_16_FK on FILIAL (
CODEMPRESA ASC
);

/*==============================================================*/
/* Table: FORMAPAGAMENTO                                        */
/*==============================================================*/
create table FORMAPAGAMENTO 
(
    CODFORMAPAGAMENTO    integer                        not null default autoincrement,
    DESCRICAO            varchar(50),
    DESCRICAOREDUZIDA    varchar(2),
    constraint PK_FORMAPAGAMENTO primary key (CODFORMAPAGAMENTO)
);

/*==============================================================*/
/* Index: FORMAPAGAMENTO_PK                                     */
/*==============================================================*/
create unique index FORMAPAGAMENTO_PK on FORMAPAGAMENTO (
CODFORMAPAGAMENTO ASC
);

/*==============================================================*/
/* Table: FORNECEDORCLIENTE                                     */
/*==============================================================*/
create table FORNECEDORCLIENTE 
(
    CODFORNECEDORCLIENTE integer                        not null default autoincrement,
    CODTIPOCLIENTE       integer,
    MUNICIPIO            varchar(10),
    CATEGORIA            varchar(50),
    CPFCNPJ              varchar(15),
    INSCRICAOESTADUAL    varchar(15),
    NOME                 varchar(50),
    NOMEFANTASIA         varchar(50),
    CONTATO              varchar(50),
    ATIVIDADE            varchar(50),
    LOGRADOURO           varchar(50),
    COMPLEMENTO          varchar(50),
    BAIRRO               varchar(50),
    CEP                  varchar(50),
    TELEFONE             varchar(16),
    TELEFONEALTERNATIVO  varchar(16),
    FAX                  varchar(16),
    CELULAR              varchar(16),
    EMAIL                varchar(50),
    EMAILALTERNATIVO     varchar(50),
    SEXO                 varchar(10),
    DATANASCIMENTO       date,
    TIPOCADASTRO         char(1),
    DATACADASTRO         date,
    constraint PK_FORNECEDORCLIENTE primary key (CODFORNECEDORCLIENTE)
);

/*==============================================================*/
/* Index: FORNECEDORCLIENTE_PK                                  */
/*==============================================================*/
create unique index FORNECEDORCLIENTE_PK on FORNECEDORCLIENTE (
CODFORNECEDORCLIENTE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_11_FK on FORNECEDORCLIENTE (
CODTIPOCLIENTE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_12_FK on FORNECEDORCLIENTE (
MUNICIPIO ASC
);

/*==============================================================*/
/* Table: MOVIMENTACAOFINANCEIRA                                */
/*==============================================================*/
create table MOVIMENTACAOFINANCEIRA 
(
    CODMOVIMENTACAOFINANCEIRA integer                        not null default autoincrement,
    CODEMPRESA           integer,
    CODCONTACORRENTE     integer,
    CODFORNECEDORCLIENTE integer,
    NUMBANCO             varchar(5),
    CODCENTROCUSTO       integer,
    HISTORICO            varchar(50),
    DATALANCAMENTO       date,
    OPERACAO             varchar(50),
    VALORLANCAMENTO      numeric(14,3),
    CONTACORRENTE        varchar(50),
    constraint PK_MOVIMENTACAOFINANCEIRA primary key (CODMOVIMENTACAOFINANCEIRA)
);

/*==============================================================*/
/* Index: MOVIMENTACAOFINANCEIRA_PK                             */
/*==============================================================*/
create unique index MOVIMENTACAOFINANCEIRA_PK on MOVIMENTACAOFINANCEIRA (
CODMOVIMENTACAOFINANCEIRA ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on MOVIMENTACAOFINANCEIRA (
CODCONTACORRENTE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_13_FK on MOVIMENTACAOFINANCEIRA (
NUMBANCO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_14_FK on MOVIMENTACAOFINANCEIRA (
CODCENTROCUSTO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_17_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_17_FK on MOVIMENTACAOFINANCEIRA (
CODFORNECEDORCLIENTE ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_18_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_18_FK on MOVIMENTACAOFINANCEIRA (
CODEMPRESA ASC
);

/*==============================================================*/
/* Table: TIPOCLIENTE                                           */
/*==============================================================*/
create table TIPOCLIENTE 
(
    CODTIPOCLIENTE       integer                        not null default autoincrement,
    DESCRICAOREDUZIDA    varchar(2),
    DESCRICAO            varchar(50),
    constraint PK_TIPOCLIENTE primary key (CODTIPOCLIENTE)
);

/*==============================================================*/
/* Index: TIPOCLIENTE_PK                                        */
/*==============================================================*/
create unique index TIPOCLIENTE_PK on TIPOCLIENTE (
CODTIPOCLIENTE ASC
);

/*==============================================================*/
/* Table: TIPODOCUMENTO                                         */
/*==============================================================*/
create table TIPODOCUMENTO 
(
    CODTIPODOCUMENTO     integer                        not null default autoincrement,
    DESCRICAO            varchar(50),
    DESCRICAOREDUZIDA    varchar(2),
    constraint PK_TIPODOCUMENTO primary key (CODTIPODOCUMENTO)
);

/*==============================================================*/
/* Index: TIPODOCUMENTO_PK                                      */
/*==============================================================*/
create unique index TIPODOCUMENTO_PK on TIPODOCUMENTO (
CODTIPODOCUMENTO ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
    CODUSUARIO           integer                        not null default autoincrement,
    MUNICIPIO            varchar(10),
    NOME                 varchar(50),
    CPF                  varchar(15),
    "LOGIN"              varchar(50),
    SENHA                varchar(50),
    DEPARTAMENTO         varchar(50),
    constraint PK_USUARIO primary key (CODUSUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
CODUSUARIO ASC
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_9_FK on USUARIO (
MUNICIPIO ASC
);

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_TIPODOCU foreign key (CODTIPODOCUMENTO)
      references TIPODOCUMENTO (CODTIPODOCUMENTO)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_FORNECED foreign key (CODFORNECEDORCLIENTE)
      references FORNECEDORCLIENTE (CODFORNECEDORCLIENTE)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_MOVIMENT foreign key (CODMOVIMENTACAOFINANCEIRA)
      references MOVIMENTACAOFINANCEIRA (CODMOVIMENTACAOFINANCEIRA)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_CONTACOR foreign key (CODCONTACORRENTE)
      references CONTACORRENTE (CODCONTACORRENTE)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_CENTROCU foreign key (CODCENTROCUSTO)
      references CENTROCUSTOS (CODCENTROCUSTO)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_BANCOS foreign key (NUMBANCO)
      references BANCOS (NUMBANCO)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_FORMAPAG foreign key (CODFORMAPAGAMENTO)
      references FORMAPAGAMENTO (CODFORMAPAGAMENTO)
      on update restrict
      on delete restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_EMPRESA foreign key (CODEMPRESA)
      references EMPRESA (CODEMPRESA)
      on update restrict
      on delete restrict;

alter table EMPRESA
   add constraint FK_EMPRESA_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on update restrict
      on delete restrict;

alter table FILIAL
   add constraint FK_FILIAL_RELATIONS_EMPRESA foreign key (CODEMPRESA)
      references EMPRESA (CODEMPRESA)
      on update restrict
      on delete restrict;

alter table FORNECEDORCLIENTE
   add constraint FK_FORNECED_RELATIONS_TIPOCLIE foreign key (CODTIPOCLIENTE)
      references TIPOCLIENTE (CODTIPOCLIENTE)
      on update restrict
      on delete restrict;

alter table FORNECEDORCLIENTE
   add constraint FK_FORNECED_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on update restrict
      on delete restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_CONTACOR foreign key (CODCONTACORRENTE)
      references CONTACORRENTE (CODCONTACORRENTE)
      on update restrict
      on delete restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_BANCOS foreign key (NUMBANCO)
      references BANCOS (NUMBANCO)
      on update restrict
      on delete restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_CENTROCU foreign key (CODCENTROCUSTO)
      references CENTROCUSTOS (CODCENTROCUSTO)
      on update restrict
      on delete restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_FORNECED foreign key (CODFORNECEDORCLIENTE)
      references FORNECEDORCLIENTE (CODFORNECEDORCLIENTE)
      on update restrict
      on delete restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_EMPRESA foreign key (CODEMPRESA)
      references EMPRESA (CODEMPRESA)
      on update restrict
      on delete restrict;

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on update restrict
      on delete restrict;

