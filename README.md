## Exercício final do curso entrypoint JAVA da Brq, professor Cid Andrade.
Enunciado: Crie um projeto com interface gráfica que contenha ao menos duas tabelas relacionadas entre si com ligação ao banco de dados.


### Simulei alguns passos de criação de um programa para aplicar conceitos vistos em aulas:
1. Levantamento de requisitos
2. Modelagem/criação do banco de dados
3. UML
4. Interface gráfica
5. Classes de conexão de Banco de dados
6. Classes de entidades de BD
7. Classes DAO
8. Conexão interface gráfica e DAO
9. Testes finais
10. Otimização de código
11. Documentação
12. As-built, APU
13. Registro de aprendizado
<br><br>

# Sumário
1. [Aprendizados e Conceitos utilizados](#aprendizados-e-conceitos-utilizados)
2. [Descrição do Sistema](#descrição-do-Sistema)
    - [Requisitos Funcionais do Sistema](#requisitos-funcionais-do-sistema)
    - [Descrição do Banco de dados](#descrição-do-banco-de-dados)
    - [Uml entidades](#uml-das-entidades)
    - [Uml classes DAO](#uml-das-classes-dao)
<br><br>

# Aprendizados e Conceitos utilizados

- Facade pattern
- DAO pattern
- Hereditarieade
- JDBC
- Formatação e inserção de datas no BD (SimpleDaateFormat)
- Interface gráfica do Java
- JDateChooser (calendario para escolher datas na interface gráfica)
- Autocomplete de comboboxes
<br><br>

# Descrição do Sistema
Programa que é capaz de adicionar um treino para um aluno de academia, referenciando o professor que o deu. 
<br>

## Requisitos Funcionais do Sistema
1. O sistema deve permitir o CRUD de alunos, professores e treinos.
2. O sistema deve ter uma aba para cada tabela.
3. O sistema deve calcular automaticamente a idade do aluno ao demonstrar na interface gráfica.2. O sistema deve ter um selecionador de data (ao invés de um campo text) para o aluno.
4. O sistema deve demonstrar os dados do banco de dados em forma de tabela na interface gráfica.
5. O sistema deve ter um campo para selecionar treinos por ID.
6. O sistema deve ter um campo para selecionar alunos por Nome.
<br>

## Descrição do Banco de dados
Tabela Aluno deve conter Matricula (Id), Nome, Data de Nascimento e Gênero, pois alguns treinos são somente aplicados a determinadas idades e gênero.

Tabela Professor deve conter apenas seu Id e Nome.

Tabela Treino recebe os id/matricula de professor e aluno, o Nome do treino e uma descrição, além de possuir um id próprio

### Diagrama do Banco de dados

![Diagrama do BD](./readmeImgs/DescricaoSistema/DiagramaAcademiaBD.png)
<br><br>

## UML das Entidades
![Uml entidades do progeam](./readmeImgs/DescricaoSistema/umlEntidades.png)
<br><br>

## UML das Classes DAO
![UML das Classes DAO](./readmeImgs/DescricaoSistema/umlDAO.png)