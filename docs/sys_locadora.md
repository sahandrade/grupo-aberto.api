# Sistema de Gerenciamento de Biblioteca

O sistema da Biblioteca Mackenzie é uma plataforma web que proporciona aos alunos cadastrados o empréstimo e reserva de livros.

## 1. Diagrama de Caso De Uso

```plantuml
@startuml
left to right direction
actor Usuário
actor Cliente
rectangle "Locadora_Autos_Numen" {
    Usuário -- (Emprestar livros)
    Usuário -- (Manter livros)
    Usuário -- (Manter usuários)
    Usuário -- (Reservar livros)
    Cliente -- (Reservar livros)
    Usuário -- (Pesquisar livros)
    Cliente -- (Pesquisar livros)
    Cliente -- (Devolver livros)
}
@enduml
```

## 2. Descrição dos Casos de Uso

### 2.1. Manter livros (CDU01)

**Resumo:** O Bibliotecário inclui, atualiza e remove os dados de um determinado livro.

**Ator Principal:** Bibliotecário

**Pré-Condições:** Ser cadastrado no sistema. O livro estar em boas condições e com as informações completas.

**Pós-Condições:** O livro está cadastrado no sistema e disponível para empréstimo.

#### Fluxo principal

1. O Bibliotecário seleciona a opção de pesquisar um livro.
2. O sistema solicita o ISNB do livro.
3. O Bibliotecário fornece o ISBN.
4. O sistema pesquisa pelo número informado.
5. O sistema verifica que não há nenhum livro cadastrado com o número digitado.
6. O sistema exibe uma mensagem que o livro não foi encontrado e fornece a opção de cadastro ou cancelamento da operação.
7. O Bibliotecario seleciona cadastrar.
8. o sistema solicita as informações sobre o livro (ISBN, titulo, autor, genero, anoEdicao, editora, qtdePaginas, qtdeDisponivel, valor).
9. O Bibliotecário fornece as informações solicitadas.
10. O sistema armazena os dados do livro em sua base de dados, gerando um novo registro único.
11. O sistema informa que o livro foi cadastrado.

#### Fluxo alternativo

##### Passo 5 (livro já está cadastrado)

- O sistema apresenta as informações do livro para edição e a opção de excluir.

6. O Bibliotecario atualiza as informações do livro.
7. O caso de uso retorna para o passo 11 do fluxo principal.

### 2.2. Acessar funções restritas (CDU02)

**Resumo:** Para ganhar acesso a informação restritas ou personalizadas, fazer reservas ou outras transações especializadas, um usuário precisa se autenticar e o sistema determinara seu nível de acesso.

**Ator Principal:** Bibliotecário

**Pré-Condições:** O usuário já se registrou.

**Pós-Condições:** O usuário pode obter informações e realizar funções disponível para seu nível de acesso.

#### Fluxo principal

1. O usuário seleciona a operação para efetuar o login.
2. O sistema solicita o seu username e sua senha.
3. O usuário insere seu username e sua senha.
4. O sistema inicia uma sessão.

#### Fluxo alternativo

##### Passo 2 (Apenas o usuário é inválido)

3.  Retorna para o passo 2

##### Passo 3 (Usuário e senha são inválidos)

3. Sistema da uma nova oportunidade para o usuário entrar a senha.
4. Insere nova senha.
5. Sistema verifica se a senha está correta e, se estiver, retorna-se para o passo 4 do fluxo principal, se não estiver, retorna-se para o passo 3 deste fluxo

### 2.3. Reservar livro (CDU03)

**Resumo:** Permite que o usuário faça uma reserva de um livro disponível na biblioteca.

**Ator Principal:** Aluno, Bibliotecário

**Pré-Condições:** O usuário deve estar logado no sistema.

**Pós-Condições:** O livro estar reservado para o usuário.

#### Fluxo principal

1. O usuário pesquisa o livro desejado no sistema.
2. O sistema exibe os resultados da pesquisa.
3. O usuário seleciona o livro desejado.
4. O sistema exibe os detalhes do livro selecionado.
5. O usuário solicita a reserva do livro.
6. O sistema registra a reserva do livro.

#### Fluxo alternativo

##### Passo 6 (Livro não disponível para reserva)

6. O sistema exibe mensagem informando que o livro não está disponível para reserva.

### 2.4. Pesquisar livro (CDU04)

**Resumo:** Permite que o usuário pesquise livros pelo título, autor ou categoria.

**Ator Principal:** Aluno

**Pré-Condições:** O usuário deve estar logado no sistema.

**Pós-Condições:** O livro estará no sistema.

#### Fluxo principal

1. O aluno acessa a funcionalidade de pesquisa de livros.
2. O sistema exibe uma caixa de pesquisa.
3. O usuário insere os termos de pesquisa.
4. O sistema realiza a busca no acervo da biblioteca.
5. O sistema exibe os resultados da pesquisa.

#### Fluxo alternativo

##### Passo 4 (livro não encontrado)

4. O sistema exibe uma mensagem informando que nenhum livro foi encontrado com os termos de pesquisa

## 3. Modelo de Domínio

```plantuml
@startuml

class Usuario {
    String : nomeCompleto
    String : dataNascimento
    Tipo : tipo
    Conta: conta
}

class Conta {
   String : email
   String : senha
   String : telefone
   bool: habilitado
}

class Aluno {
    Aluno : matricula
}

class Livro {
    Livro : titulo
    Livro : genero
    Livro : anoEdicao
    Livro : editora
    Livro : autor
    Livro : qtdePaginas
    Livro : ISBN
    Livro : qtdeDisponivel
    Livro : valor
}

class Tag {
    Tag : tag
}

class Reserva {
    Reserva : status
    Reserva : dataReserva
}

class Emprestimo {
    Emprestimo : emprestadoEm
    Emprestimo : status
    Emprestimo : devolucaoPrevista
    Emprestimo : devolvidoEm
    Emprestimo : multaAplicada
}

class Multa {
    Multa : valor
    Multa : descricao
    Multa : status
}

Usuario <|-- Bibliotecario
Usuario <|-- Aluno

Aluno "*" -up- "*" Livro : emprestar <
(Aluno, Livro) .. Emprestimo

Aluno "*" -up- "*" Livro : reservar <
(Aluno, Livro) .. Reserva

Emprestimo "1" -- "0.1" Multa : conter >

Emprestimo "*" -up- "1" Bibliotecario : registrar <

Livro "*" -- "*" Tag

@enduml
```

## 4. Diagramas de Sequência

### 4.1 Manter Livro (CDS01 - Fluxo principal)

```plantuml
@startuml

hide footbox
actor Bibliotecario
boundary "__bibliotecarioBoundary__" as bb
control "__bibliotecaControl__" as bc
entity "__livrosAcervo__" as la

Bibliotecario -> bb : 1. seleciona a opção de pesquisar um livro
activate bb
bb -> bb : 2. solicita o ISNB do livro
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 3. fornece o ISBN
activate bb
bb -> bc : buscarLivrosQueContenham(numero)
activate bc
bc -> la : buscarLivrosPeloISBN(numero)
activate la
bc <<-- la : livrosResultanteDaBusca
deactivate la
bc -->> bb : livrosResultanteDaBusca
deactivate bc
bb -> bb : 6. apresenta a mensagem que nenhum livro foi encontrado, e as opção de cadastrar novo livro ou cancelar
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 7. seleciona a opção de cadastrar novo livro
activate bb
bb -> bb : 8. solicita as informações sobre o livro (ISBN, titulo, autor, genero, anoEdicao, editora, qtdePaginas, qtdeDisponivel, valor)
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 9. fornece as informações solicitadas
activate bb
bb -> bc : cadastrarLivro(ISBN, titulo, autor, genero, anoEdicao, editora, qtdePaginas, qtdeDisponivel, valor)
activate bc
create "__livro:Livro__" as livro
bc --> livro : <<create>> new Livro(ISBN, titulo, autor, genero, anoEdicao, editora, qtdePaginas, qtdeDisponivel, valor)
bc -> la : salvar(livro)
activate la
deactivate la
deactivate bc
bb -> bb : 11. informa que o livro foi cadastrado
activate bb
deactivate bb
deactivate bb

@enduml
```

### 4.1 Manter Livro (CDS01 - Fluxo alternativo)

```plantuml
@startuml

hide footbox
actor Bibliotecario
boundary "__bibliotecarioBoundary__" as bb
control "__bibliotecaControl__" as bc
entity "__livrosAcervo__" as la

Bibliotecario -> bb : 1. seleciona a opção de pesquisar um livro
activate bb
bb -> bb : 2. solicita o ISNB do livro
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 3. fornece o ISBN
activate bb
bb -> bc : buscarLivroQueContenham(numero)
activate bc
bc -> la : buscarLivroPeloISBN(numero)
activate la
bc <<-- la : livroResultanteDaBusca
deactivate la
bc -->> bb : livroResultanteDaBusca
deactivate bc
bb -> bb : 6. apresenta as informações do livro para editação e a opção de deletar
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 7. atualiza as informações do livro
activate bb
bb -> bc : atualizarLivro(livro)
activate bc
bc -> la : atualizarLivro(livro)
activate la
deactivate la
deactivate bc
bb -> bb : 11. informa que o livro foi atualizado
activate bb
deactivate bb
deactivate bb

@enduml
```

### 4.2.1 Acessar funções restritas (CDU02 - Fluxo principal)

```plantuml
@startuml

hide footbox
actor Bibliotecario
boundary "__accessControl__" as ac
entity "__accessDataBase__" as adb


Bibliotecario -> ac : 1. Insere usuário e senha
activate ac
ac -> adb : 2. Busca SQL por usuário
activate adb
adb -> adb : 2. Executa query
adb -> ac : 3. Retorna sucesso
ac -> Bibliotecario  : 4. Concede acesso

@enduml
```

### 4.2.2 Acessar funções restritas (CDU02 - Fluxo alternativo)

```plantuml
@startuml

hide footbox
actor Bibliotecario
boundary "__accessControl__" as ac
entity "__accessDataBase__" as adb


Bibliotecario -> ac : 1. Insere usuário e senha
activate ac
ac -> adb : 2. Busca SQL por usuário
activate adb
adb -> adb : 2. Executa query
adb -> ac : 3. Retorna falha
ac -> Bibliotecario  : 4. Retorna mensagem de falha

@enduml
```

### 4.3 Reservar Livro (CDS03 - Fluxo principal)

```plantuml
@startuml

hide footbox
actor Aluno
boundary "__alunoBoundary__" as bb
control "__bibliotecaControl__" as bc
entity "__livrosAcervo__" as la

Aluno -> bb : 1. seleciona a opção de pesquisar um livro
activate bb
bb -> bb : 2. solicita String para pesquisar livro
activate bb
deactivate bb
deactivate bb

Aluno -> bb : 3. fornece o ISBN
activate bb
bb -> bc : buscarLivroQueContenham(numero)
activate bc
bc -> la : buscarLivroPeloISBN(numero)
activate la
bc <<-- la : livroResultanteDaBusca
deactivate la
bc -->> bb : livroResultanteDaBusca
deactivate bc
bb -> bb : 6. apresenta as informações do livro e opção de reservar
activate bb
deactivate bb
deactivate bb

Aluno -> bb : 7. Executa reserva do livro
activate bb
bb -> bc : reservarLivro(livro)
activate bc
bc -> la : reservarLivro(livro)
activate la
deactivate la
deactivate bc
bb -> bb : 11. informa mensagem que livro foi reservado
activate bb
deactivate bb
deactivate bb

@enduml
```

### 4.4 Pesquisar livro (CDU04 - Fluxo principal)

```plantuml
@startuml

hide footbox
actor Bibliotecario
boundary "__bibliotecarioBoundary__" as bb
control "__bibliotecaControl__" as bc
entity "__livrosAcervo__" as la

Bibliotecario -> bb : 1. seleciona a opção de pesquisar um livro
activate bb
bb -> bb : 2. solicita String para pesquisar livro
activate bb
deactivate bb
deactivate bb

Bibliotecario -> bb : 3. Insere dados
activate bb
bb -> bc : buscarLivroQueContenham(String)
activate bc
bc -> la : buscarLivro(String)
activate la
bc <<-- la : livroResultanteDaBusca
deactivate la
bc -->> bb : livroResultanteDaBusca
deactivate bc
bb -> bb : 6. apresenta as informações do livro
activate bb
deactivate bb
deactivate bb

@enduml
```

## 5. Diagramas de classes de projeto

```plantuml
@startuml

class bibliotecaController {
    List<Books> getBooks(String isbn)
    Book insertBook(Book book)
    Book updateBook(String isbn, Book book)
    Book deleteBook(String isbn)
    String reserveBook(String isbn)
}

interface bibliotecaRepo{

}

interface bibliotecaRepository{

}


bibliotecaController --|> bibliotecaRepo
bibliotecaRepo --|> bibliotecaRepository


@enduml
```
