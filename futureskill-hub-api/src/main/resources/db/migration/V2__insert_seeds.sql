-- Dados iniciais de competencias
INSERT INTO competencias (nome, categoria, descricao) VALUES
('Inteligência Artificial', 'Tecnologia', 'Fundamentos de IA e uso ético de modelos'),
('Análise de Dados', 'Tecnologia', 'Análise exploratória e tomada de decisão baseada em dados'),
('Empatia e Colaboração', 'Humana', 'Competências socioemocionais para trabalho em equipe'),
('Green Tech', 'Tecnologia', 'Tecnologias voltadas à sustentabilidade e economia verde');

-- Dados iniciais de trilhas de aprendizagem
INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal) VALUES
('Introdução à IA para Negócios', 'Fundamentos de IA aplicada ao dia a dia profissional.', 'INICIANTE', 20, 'IA'),
('Análise de Dados para Tomada de Decisão', 'Trilha focada em dados para apoio à gestão.', 'INTERMEDIARIO', 40, 'Dados'),
('Soft Skills para o Futuro do Trabalho', 'Empatia, comunicação e colaboração em ambientes híbridos.', 'INICIANTE', 16, 'Soft Skills'),
('Green Tech & Sustentabilidade', 'Tecnologias e práticas para economia verde.', 'AVANCADO', 30, 'Green Tech');

-- Dados iniciais de usuários
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
('Maria Silva', 'maria.silva@example.com', 'Finanças', 'Em transição', CURRENT_DATE),
('João Santos', 'joao.santos@example.com', 'TI', 'Junior', CURRENT_DATE),
('Ana Costa', 'ana.costa@example.com', 'RH', 'Pleno', CURRENT_DATE);