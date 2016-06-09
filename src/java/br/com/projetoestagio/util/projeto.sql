 ﻿CREATE TABLE AlimentoRefeicao(
id_alimento_refeicao serial,
quantidade_alimento_refeicao int,
tipo_medida_alimento_refeicao varchar(20),
sincroniza_alimento_refeicao int,
id_alimento int NOT NULL,
id_refeicao int NOT NULL,
CONSTRAINT pk_alimentorefeicao PRIMARY KEY (id_alimento_refeicao),
CONSTRAINT fk_alimento FOREIGN KEY(id_alimento) REFERENCES Alimento,
CONSTRAINT fk_refeicao FOREIGN KEY(id_refeicao) REFERENCES Refeicao
);


CREATE TABLE AvaliacaoPatologia(
id_avaliacao_patologia serial,
status_avaliacao_patologia char(1),
sincronizaAvaliacaoPatologia int,
id_patologia int NOT NULL,
id_avaliacao int NOT NULL,
CONSTRAINT pk_avaliacaopatologia PRIMARY KEY(id_avaliacao_patologia),
CONSTRAINT fk_patologia FOREIGN KEY(id_patologia) REFERENCES Patologia,
CONSTRAINT fk_avaliacao FOREIGN KEY(id_avaliacao) REFERENCES Avaliacao
);

CREATE TABLE AvaliacaoMedicamentoSuplemento(
id_avaliacao_medicamento_suplemento serial,
dose_avaliacao_medicamento_suplemento int,
frequencia_avaliacao_medicamento_suplemento varchar(100),
status_avaliacao_medicamento_suplemento char(1),
sincroniza_avaliacao_medicamento_suplemento int,
id_medicamento_suplemento int NOT NULL,
id_avaliacao int NOT NULL,
CONSTRAINT pk_avaliacaomedicamentosuplemento PRIMARY KEY(id_avaliacao_medicamento_suplemento),
CONSTRAINT fk_medicamentosuplemento FOREIGN KEY(id_medicamento_suplemento) REFERENCES MedicamentoSuplemento,
CONSTRAINT fk_avaliacao FOREIGN KEY(id_avaliacao) REFERENCES Avaliacao
);

CREATE TABLE Pessoa(
id_pessoa serial,
nome_pessoa varchar(50) NOT NULL,
telefone_pessoa int NOT NULL,
email_pessoa varchar(50) NOT NULL,
senha_pessoa varchar(15) NOT NULL,
status_pessoa varchar(10) NOT NULL,
sincroniza_pessoa int,
CONSTRAINT pk_pessoa PRIMARY KEY (id_pessoa)
);

CREATE TABLE Paciente(
id_paciente serial,
data_nascimento_paciente date NOT NULL,
sexo_paciente char(1) NOT NUll,
idade_paciente int NOT NULL,
id_pessoa int NOT NULL,
CONSTRAINT pk_paciente PRIMARY KEY (id_paciente),
CONSTRAINT fk_idpessoa FOREIGN KEY (id_pessoa) REFERENCES Pessoa
);


CREATE TABLE Nutricionista(
id_nutricionista serial,
crn_nutricionista int NOT NULL,
id_pessoa int NOT NULL,
CONSTRAINT pk_nutricionista PRIMARY KEY (id_nutricionista),
CONSTRAINT fk_idPessoa FOREIGN KEY (id_pessoa) REFERENCES Pessoa
);

CREATE TABLE Consulta(
id_consulta serial,
data_consulta date NOT NULL,
hora_consulta time without time zone NOT NULL,
conduta_nutricional_consulta text,
observacao_consulta text,
status_consulta char(1),
sincroniza_consulta int,
id_paciente int not null ,
id_nutricionista int not null,
CONSTRAINT pk_consulta PRIMARY KEY (id_consulta),
CONSTRAINT fk_paciente FOREIGN KEY (id_paciente) REFERENCES Paciente,
CONSTRAINT fk_nutricionista FOREIGN KEY (id_nutricionista) REFERENCES Nutricionista
);



CREATE TABLE Exame(
id_exame serial,
nome_exame varchar(100) NOT NULL,
imagem_exame oid,
data_exame date NOT NULL,
sincroniza_exame int,
status_exame char(1),
id_consulta int NOT NULL,
CONSTRAINT pk_examelabor PRIMARY KEY(id_exame),
CONSTRAINT fk_consulta FOREIGN KEY(id_consulta) REFERENCES Consulta
);

CREATE TABLE Cardapio(
id_cardapio serial,
tipo_cardapio varchar(30) NOT NULL,
nome_cardapio varchar(30) NOT NULL,
data_inicio_cardapio date,
data_final_cardapio date,
observacao_cardapio text,
status_cardapio char(1),
sincroniza_cardapio int,
id_paciente int NOT NULL,
CONSTRAINT pk_cardapio PRIMARY KEY (id_cardapio),
CONSTRAINT fk_consulta FOREIGN KEY (id_paciente) REFERENCES Paciente
);	

CREATE TABLE TipoRefeicao(
id_tipo_refeicao serial,
tipo_refeicao varchar(20),
sincroniza_tipo_refeicao int,
CONSTRAINT pk_tiporefeicao PRIMARY KEY(id_tipo_refeicao)
);	


CREATE TABLE Refeicao(
id_refeicao serial,
hora_refeicao time without time zone,
dia_refeicao date,
status_refeicao char(1),
sincroniza_refeicao int,
id_tipo_refeicao int not null,
id_cardapio int not null,
CONSTRAINT pk_refeicao PRIMARY KEY (id_refeicao),
CONSTRAINT fk_refeicao_tipo foreign key  (id_tipo_refeicao) references TipoRefeicao,
CONSTRAINT fk_refeicao_cardapio foreign key (id_cardapio) references Cardapio
);


CREATE TABLE Alimento(
id_alimento serial,
nome_tabela_nutricional_alimento varchar(50) NOT NULL,
nome_alimento varchar(100) NOT NULL,
tipo_alimento varchar(50) NOT NULL,
especie_alimento varchar(50),
proteina_alimento decimal(4,2),
lipideo_alimento decimal(4,2),
carboidrato_alimento decimal(4,2),
fibra_alimentar_alimento decimal(4,2),
status_alimento char(1),
sincroniza_alimento int,
CONSTRAINT pk_alimento PRIMARY KEY (id_alimento)
);



CREATE TABLE FrequenciaAlimentar(
id_frequencia_alimentar serial,
fruta_frequencia_alimentar int,
verduras_frequencia_alimentar int,
legumes_frequencia_alimentar int,
carne_vermelha_frequencia_alimentar int,
carne_branca_frequencia_alimentar int,
leite_derivados_frequencia_alimentar int,
ovos_frequencia_alimentar int,
cereais_frequencia_alimentar int,
massas_frequencia_alimentar int,
leguminosas_frequencia_alimentar int,
paes_frequencia_alimentar int,
doces_frequencia_alimentar int,
refrigerante_frequencia_alimentar int,
alcool_frequencia_alimentar int,
gordurosos_frequencia_alimentar int,
sincroniza_frequencia_alimentar int,
status_frequencia_alimentar char(1),
CONSTRAINT pk_frequenciaalimentar PRIMARY KEY (id_frequencia_alimentar)
);

CREATE TABLE Avaliacao(
id_Avaliacao serial,
peso_paciente decimal (5,2) NOT NULL,
altura_paciente decimal (4,2) NOT NULL,
circun_punho_avaliacao decimal (4,2) NOT NULL,
circun_cintura_avaliacao decimal (4,2) NOT NULL,
circun_quadril_avaliacao decimal (4,2) NOT NULL,
data_avaliacao date  NOT NULL,
meta_avaliacao int,
observacao_importante_avaliacao text,
peso_desejavel_avaliacao decimal (5,2),
objetivo_avaliacao text,
colesterol int,
triglicerideos int,
diabetes int,
patologia_avaliacao char(1),
acompan_avaliacao char(1),
conduta_adotada_avaliacao text,
qtd_agua_avaliacao decimal(2,1),
fumaAvaliacao char(1),
func_intestino_avaliacao text,
urina_avaliacao text,
local_alim_avaliacao varchar(200),
ingere_medc_avaliacao char(1),
ingere_suple_avaliacao char(1),
pratica_exercicio_avaliacao char(1),
sincroniza_avaliacao int,
status_avaliacao char(1),
id_consulta int NOT NULL,
id_frequencia_alimentar int NOT NULL,
CONSTRAINT pk_avaliacao PRIMARY KEY(id_avaliacao),
CONSTRAINT fk_consulta FOREIGN KEY (id_consulta) REFERENCES Consulta,
CONSTRAINT fk_freqenciaalimentar FOREIGN KEY(id_frequencia_alimentar) REFERENCES FrequenciaAlimentar
);



CREATE TABLE Exercicio(
id_exercicio serial,
nome_exercicio varchar(50),
tipo_exercicio varchar(50),
frequencia_exercicio varchar(50),
total_horas_exercicio real,
intensidade_exercicio varchar(50),
status_exercicio char(1),
sincroniza_exercicio int,
id_avaliacao int NOT NULL,
CONSTRAINT pk_exercicio PRIMARY KEY (id_exercicio),
CONSTRAINT fk_avaliacao FOREIGN KEY (id_avaliacao) REFERENCES Avaliacao
);

CREATE TABLE MedicamentoSuplemento(
id_medicamento_suplemento serial,
nome_medicamento_suplemento varchar(100) NOT NULL,
tipo_medicamento_suplemento varchar(50) NOT NULL,
sincroniza_medicamento_suplemento int,
status_medicamento_suplemento char(1),
CONSTRAINT pk_medicamentoSuplemento PRIMARY KEY(id_medicamento_suplemento)
);


CREATE TABLE Patologia(
id_patologia serial,
nome_patologia varchar(50),
descricao_patologia text,
historico_familia_patologia text,
sincroniza_patologia int,
status_patologia char(1),
CONSTRAINT pk_patologia PRIMARY KEY (id_patologia)
);

select*from  refeicao




























