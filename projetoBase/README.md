# projeto-ip
Tapiocão da tia

## Especificação de Requisitos do Projeto:

### Individual:

- No mínimo uma classe básica  (Ex. Conta, Livro, Funcionário, DVD). Deve haver pelo menos uma relação entre duas classes básicas;

- Duas classes coleção de dados para cada classe básica (Ex. No caso da classe básica Conta, seriam os seguintes repositórios: RepositorioContasArray e RepositorioContasLista). Lembre-se de criar uma interface negócio-dados para as classes de repositórios;

- Uma classe coleção de negócio que usa a interface das coleções de dados para armazenar os objetos das classes básicas e, se for o caso, define regras (validações) para cadastrar, remover, atualizar e procurar objetos no sistema. (Ex. CadastroContas);

- Usem exceções como mostrado em sala.

### Todo Mundo:
- Usem herança (onde for necessário e viável);

- Deve haver pelo menos um exemplo de classe abstrata (já serve como exemplo de herança);

- Deve ser criada uma classe fachada que tem como atributos todos os cadastros do sistema. Por exemplo, no caso de um projeto com três classes básicas devem haver seis coleções de dados, três classes coleção de negócio e uma classe fachada com 3 atributos (os 3 cadastros). A classe fachada é quem deve fazer validações que envolvem mais de um cadastro;

- Definam uma Classe Programa no pacote ui que testa a classe fachada (estes testes devem ser fixos, sem ler do teclado, apenas para ver se os métodos funcionam e servem para vocês testarem o projeto);

- Usem pacotes. A sugestão é que haja um pacote para cada classe básica (use o nome da classe básica no plural como nome do pacote). Neste pacote deve estar a classe básica, as coleções, a interface das coleções, o cadastro, e as exceções relacionadas. Isto facilita a integração do projeto, pois cada integrante será responsável por um pacote. Coloque a classe Fachada e a classe Programa em dois pacotes separados.


### Critérios de Avaliação e Pesos:

- Classes básicas = 4;

- Relação entre as classes = 4;

- Uso de pacotes = 1;

- Uso de herança = 2;

- Classe abstrata = 2;

- Uso de exceções = 3;

- Repositório Array = 2;

- Repositório Lista = 5;

- Interface repositório = 2;

- Camada de negócio = 10;

- Camada fachada = 10;

- Programa teste = 5.

Obs: Bônus dado de acordo com a escolha do monitor.

Obs2: Apesar da correção ser feita com toda a equipe, o monitor poderá fazer perguntas individuais para cada membro e atribuir uma nota de participação com base nessas perguntas.
