/*==============================================================*/
/* DBMS name:      PostgreSQL 7.3                               */
/* Created on:     17/3/2009 00:06:03                           */
/*==============================================================*/




/*==============================================================*/
/* Table: BANCOS                                                */
/*==============================================================*/
create table BANCOS (
NUMBANCO             VARCHAR(5)           not null,
DESCRICAO            VARCHAR(50)          null,
constraint PK_BANCOS primary key (NUMBANCO)
);

/*==============================================================*/
/* Index: BACNOS_PK                                             */
/*==============================================================*/
create unique index BACNOS_PK on BANCOS (
NUMBANCO
);

/*==============================================================*/
/* Table: CENTROCUSTOS                                          */
/*==============================================================*/
create table CENTROCUSTOS (
CODCENTROCUSTO       SERIAL               not null,
DESCRICAOCENTROCUSTO VARCHAR(50)          null,
CODIGOCENTROCUSTO    VARCHAR(16)          null,
constraint PK_CENTROCUSTOS primary key (CODCENTROCUSTO)
);

/*==============================================================*/
/* Index: CENTROCUSTOS_PK                                       */
/*==============================================================*/
create unique index CENTROCUSTOS_PK on CENTROCUSTOS (
CODCENTROCUSTO
);

/*==============================================================*/
/* Table: CIDADES                                               */
/*==============================================================*/
create table CIDADES (
MUNICIPIO            VARCHAR(10)          not null,
UF                   VARCHAR(2)           null,
DESCRICAO            VARCHAR(50)          null,
constraint PK_CIDADES primary key (MUNICIPIO)
);

/*==============================================================*/
/* Index: CIDADES_PK                                            */
/*==============================================================*/
create unique index CIDADES_PK on CIDADES (
MUNICIPIO
);

/*==============================================================*/
/* Table: CONTACORRENTE                                         */
/*==============================================================*/
create table CONTACORRENTE (
CODCONTACORRENTE     SERIAL               not null,
DESCRICAO            VARCHAR(50)          null,
AGENCIA              VARCHAR(30)          null,
NUMEROCONTACORRENTE  INT4                 null,
SALDOINICIAL         NUMERIC(14,3)        null,
ATIVAINATIVA         BOOL                 null,
constraint PK_CONTACORRENTE primary key (CODCONTACORRENTE)
);

/*==============================================================*/
/* Index: CONTACORRENTE_PK                                      */
/*==============================================================*/
create unique index CONTACORRENTE_PK on CONTACORRENTE (
CODCONTACORRENTE
);

/*==============================================================*/
/* Table: CONTAS                                                */
/*==============================================================*/
create table CONTAS (
CODCONTAS            SERIAL               not null,
CODEMPRESA           INT4                 null,
CODMOVIMENTACAOFINANCEIRA INT4                 null,
NUMBANCO             VARCHAR(5)           null,
CODFORMAPAGAMENTO    INT4                 null,
CODTIPODOCUMENTO     INT4                 null,
CODCENTROCUSTO       INT4                 null,
CODCONTACORRENTE     INT4                 null,
NUMERODOCUMENTO      VARCHAR(50)          null,
STATUS               VARCHAR(2)           null,
AGENCIA              VARCHAR(30)          null,
SITUACAODOCUMENTO    VARCHAR(2)           null,
DIASPROTESTO         VARCHAR(4)           null,
DATAEMISSAO          DATE                 null,
DATAVENCIMENTO       DATE                 null,
VALOR                NUMERIC(14,3)        null,
NUMERONOTAFISCAL     VARCHAR(50)          null,
VALORNOTAFISCAL      NUMERIC(14,3)        null,
NUMEROBOLETO         VARCHAR(50)          null,
VALORPAGO            NUMERIC(14,3)        null,
DATALIQUIDACAO       DATE                 null,
HISTORICO            VARCHAR(50)          null,
constraint PK_CONTAS primary key (CODCONTAS)
);

/*==============================================================*/
/* Index: CONTAS_PK                                             */
/*==============================================================*/
create unique index CONTAS_PK on CONTAS (
CODCONTAS
);

/*==============================================================*/
/* Index: RELATIONSHIP_2_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_2_FK on CONTAS (
CODMOVIMENTACAOFINANCEIRA
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on CONTAS (
CODCONTACORRENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_4_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_4_FK on CONTAS (
CODCENTROCUSTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on CONTAS (
NUMBANCO
);

/*==============================================================*/
/* Index: RELATIONSHIP_6_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_6_FK on CONTAS (
CODFORMAPAGAMENTO
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_7_FK on CONTAS (
CODEMPRESA
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_10_FK on CONTAS (
CODTIPODOCUMENTO
);

/*==============================================================*/
/* Table: EMPRESA                                               */
/*==============================================================*/
create table EMPRESA (
CODEMPRESA           SERIAL               not null,
MUNICIPIO            VARCHAR(10)          null,
RAZAOSOCIAL          VARCHAR(50)          null,
NOMEFANTASIA         VARCHAR(50)          null,
PORTEEMPRESA         VARCHAR(50)          null,
RAMOATIVIDADE        VARCHAR(50)          null,
HOMEPAGE             VARCHAR(50)          null,
constraint PK_EMPRESA primary key (CODEMPRESA)
);

/*==============================================================*/
/* Index: EMPRESA_PK                                            */
/*==============================================================*/
create unique index EMPRESA_PK on EMPRESA (
CODEMPRESA
);

/*==============================================================*/
/* Index: RELATIONSHIP_8_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_8_FK on EMPRESA (
MUNICIPIO
);

/*==============================================================*/
/* Table: FILIAL                                                */
/*==============================================================*/
create table FILIAL (
CNPJ                 VARCHAR(18)          null,
INSCRICAOESTADUAL    VARCHAR(15)          null,
INSCRICAOMUNICIPAL   VARCHAR(50)          null,
LOGRADOURO           VARCHAR(50)          null,
COMPLEMENTO          VARCHAR(50)          null,
NUMERO               VARCHAR(50)          null,
BAIRRO               VARCHAR(50)          null,
REGISTROJUNTACOMERCIAL VARCHAR(50)          null,
EMAIL                VARCHAR(50)          null,
TELEFONE             VARCHAR(16)          null,
FAX                  VARCHAR(16)          null,
CONTATO              VARCHAR(50)          null
);

/*==============================================================*/
/* Table: FORMAPAGAMENTO                                        */
/*==============================================================*/
create table FORMAPAGAMENTO (
CODFORMAPAGAMENTO    SERIAL               not null,
DESCRICAO            VARCHAR(50)          null,
DESCRICAOREDUZIDA    VARCHAR(2)           null,
constraint PK_FORMAPAGAMENTO primary key (CODFORMAPAGAMENTO)
);

/*==============================================================*/
/* Index: FORMAPAGAMENTO_PK                                     */
/*==============================================================*/
create unique index FORMAPAGAMENTO_PK on FORMAPAGAMENTO (
CODFORMAPAGAMENTO
);

/*==============================================================*/
/* Table: FORNECEDORCLIENTE                                     */
/*==============================================================*/
create table FORNECEDORCLIENTE (
CODFORNECEDORCLIENTE SERIAL               not null,
CODTIPOCLIENTE       INT4                 null,
MUNICIPIO            VARCHAR(10)          null,
CATEGORIA            VARCHAR(50)          null,
CPFCNPJ              VARCHAR(18)          null,
INSCRICAOESTADUAL    VARCHAR(15)          null,
NOME                 VARCHAR(50)          null,
NOMEFANTASIA         VARCHAR(50)          null,
CONTATO              VARCHAR(50)          null,
ATIVIDADE            VARCHAR(50)          null,
LOGRADOURO           VARCHAR(50)          null,
COMPLEMENTO          VARCHAR(50)          null,
BAIRRO               VARCHAR(50)          null,
CEP                  VARCHAR(50)          null,
TELEFONE             VARCHAR(16)          null,
TELEFONEALTERNATIVO  VARCHAR(16)          null,
FAX                  VARCHAR(16)          null,
CELULAR              VARCHAR(16)          null,
EMAIL                VARCHAR(50)          null,
EMAILALTERNATIVO     VARCHAR(50)          null,
SEXO                 VARCHAR(10)          null,
DATANASCIMENTO       DATE                 null,
TIPOCADASTRO         VARCHAR(1)           null,
DATACADASTRO         DATE                 null,

constraint PK_FORNECEDORCLIENTE primary key (CODFORNECEDORCLIENTE)
);

/*==============================================================*/
/* Index: FORNECEDORCLIENTE_PK                                  */
/*==============================================================*/
create unique index FORNECEDORCLIENTE_PK on FORNECEDORCLIENTE (
CODFORNECEDORCLIENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_11_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_11_FK on FORNECEDORCLIENTE (
CODTIPOCLIENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_12_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_12_FK on FORNECEDORCLIENTE (
MUNICIPIO
);

/*==============================================================*/
/* Table: MOVIMENTACAOFINANCEIRA                                */
/*==============================================================*/
create table MOVIMENTACAOFINANCEIRA (
CODMOVIMENTACAOFINANCEIRA SERIAL               not null,
CODCONTACORRENTE     INT4                 null,
NUMBANCO             VARCHAR(5)           null,
CODCENTROCUSTO       INT4                 null,
HISTORICO            VARCHAR(50)          null,
DATALANCAMENTO       DATE                 null,
OPERACAO             VARCHAR(50)          null,
VALORLANCAMENTO      NUMERIC(14,3)        null,
CONTACORRENTE        VARCHAR(50)          null,
constraint PK_MOVIMENTACAOFINANCEIRA primary key (CODMOVIMENTACAOFINANCEIRA)
);

/*==============================================================*/
/* Index: MOVIMENTACAOFINANCEIRA_PK                             */
/*==============================================================*/
create unique index MOVIMENTACAOFINANCEIRA_PK on MOVIMENTACAOFINANCEIRA (
CODMOVIMENTACAOFINANCEIRA
);

/*==============================================================*/
/* Index: RELATIONSHIP_1_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_1_FK on MOVIMENTACAOFINANCEIRA (
CODCONTACORRENTE
);

/*==============================================================*/
/* Index: RELATIONSHIP_13_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_13_FK on MOVIMENTACAOFINANCEIRA (
NUMBANCO
);

/*==============================================================*/
/* Index: RELATIONSHIP_14_FK                                    */
/*==============================================================*/
create  index RELATIONSHIP_14_FK on MOVIMENTACAOFINANCEIRA (
CODCENTROCUSTO
);

/*==============================================================*/
/* Table: TIPOCLIENTE                                           */
/*==============================================================*/
create table TIPOCLIENTE (
CODTIPOCLIENTE       SERIAL               not null,
DESCRICAOREDUZIDA    VARCHAR(2)           null,
DESCRICAO            VARCHAR(50)          null,
constraint PK_TIPOCLIENTE primary key (CODTIPOCLIENTE)
);

/*==============================================================*/
/* Index: TIPOCLIENTE_PK                                        */
/*==============================================================*/
create unique index TIPOCLIENTE_PK on TIPOCLIENTE (
CODTIPOCLIENTE
);

/*==============================================================*/
/* Table: TIPODOCUMENTO                                         */
/*==============================================================*/
create table TIPODOCUMENTO (
CODTIPODOCUMENTO     SERIAL               not null,
DESCRICAO            VARCHAR(50)          null,
DESCRICAOREDUZIDA    VARCHAR(2)           null,
constraint PK_TIPODOCUMENTO primary key (CODTIPODOCUMENTO)
);

/*==============================================================*/
/* Index: TIPODOCUMENTO_PK                                      */
/*==============================================================*/
create unique index TIPODOCUMENTO_PK on TIPODOCUMENTO (
CODTIPODOCUMENTO
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
CODUSUARIO           SERIAL               not null,
MUNICIPIO            VARCHAR(10)          null,
NOME                 VARCHAR(50)          null,
CPF                  VARCHAR(15)          null,
LOGIN                VARCHAR(50)          null,
SENHA                VARCHAR(50)          null,
DEPARTAMENTO         VARCHAR(50)          null,
constraint PK_USUARIO primary key (CODUSUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
CODUSUARIO
);

/*==============================================================*/
/* Index: RELATIONSHIP_9_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_9_FK on USUARIO (
MUNICIPIO
);

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_TIPODOCU foreign key (CODTIPODOCUMENTO)
      references TIPODOCUMENTO (CODTIPODOCUMENTO)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_MOVIMENT foreign key (CODMOVIMENTACAOFINANCEIRA)
      references MOVIMENTACAOFINANCEIRA (CODMOVIMENTACAOFINANCEIRA)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_CONTACOR foreign key (CODCONTACORRENTE)
      references CONTACORRENTE (CODCONTACORRENTE)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_CENTROCU foreign key (CODCENTROCUSTO)
      references CENTROCUSTOS (CODCENTROCUSTO)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_BANCOS foreign key (NUMBANCO)
      references BANCOS (NUMBANCO)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_FORMAPAG foreign key (CODFORMAPAGAMENTO)
      references FORMAPAGAMENTO (CODFORMAPAGAMENTO)
      on delete restrict on update restrict;

alter table CONTAS
   add constraint FK_CONTAS_RELATIONS_EMPRESA foreign key (CODEMPRESA)
      references EMPRESA (CODEMPRESA)
      on delete restrict on update restrict;

alter table EMPRESA
   add constraint FK_EMPRESA_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on delete restrict on update restrict;

alter table FORNECEDORCLIENTE
   add constraint FK_FORNECED_RELATIONS_TIPOCLIE foreign key (CODTIPOCLIENTE)
      references TIPOCLIENTE (CODTIPOCLIENTE)
      on delete restrict on update restrict;

alter table FORNECEDORCLIENTE
   add constraint FK_FORNECED_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on delete restrict on update restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_CONTACOR foreign key (CODCONTACORRENTE)
      references CONTACORRENTE (CODCONTACORRENTE)
      on delete restrict on update restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_BANCOS foreign key (NUMBANCO)
      references BANCOS (NUMBANCO)
      on delete restrict on update restrict;

alter table MOVIMENTACAOFINANCEIRA
   add constraint FK_MOVIMENT_RELATIONS_CENTROCU foreign key (CODCENTROCUSTO)
      references CENTROCUSTOS (CODCENTROCUSTO)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_RELATIONS_CIDADES foreign key (MUNICIPIO)
      references CIDADES (MUNICIPIO)
      on delete restrict on update restrict;

