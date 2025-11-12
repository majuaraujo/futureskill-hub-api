-- Criação das tabelas principais (compatível com H2)

CREATE TABLE usuarios (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    area_atuacao VARCHAR(100),
    nivel_carreira VARCHAR(50),
    data_cadastro DATE NOT NULL
);

CREATE TABLE trilhas (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    descricao VARCHAR(1000),
    nivel VARCHAR(50) NOT NULL,
    carga_horaria INT NOT NULL,
    foco_principal VARCHAR(100)
);

CREATE TABLE competencias (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100),
    descricao VARCHAR(1000)
);

CREATE TABLE trilha_competencia (
    trilha_id BIGINT NOT NULL,
    competencia_id BIGINT NOT NULL,
    PRIMARY KEY (trilha_id, competencia_id),
    CONSTRAINT fk_trilha_competencia_trilha
        FOREIGN KEY (trilha_id) REFERENCES trilhas (id),
    CONSTRAINT fk_trilha_competencia_competencia
        FOREIGN KEY (competencia_id) REFERENCES competencias (id)
);

CREATE TABLE matriculas (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    usuario_id BIGINT NOT NULL,
    trilha_id BIGINT NOT NULL,
    data_inscricao DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_matricula_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    CONSTRAINT fk_matricula_trilha
        FOREIGN KEY (trilha_id) REFERENCES trilhas (id)
);
