# Sistema Bancário Simples em Java

Este é um sistema bancário simples implementado em Java, que permite aos usuários fazer login, registrar-se, visualizar informações da conta, alterar dados da conta e realizar operações bancárias básicas, como depósito, saque e transferência.

## Funcionalidades

- **Login e Registro**: Os usuários podem fazer login com um código de conta e senha, ou registrar uma nova conta.
- **Visualização de Dados da Conta**: Os usuários podem ver suas informações de conta, como nome, tipo de conta e saldo.
- **Alteração de Dados da Conta**: Os usuários podem alterar seu nome e senha.
- **Operações Bancárias**: Os usuários podem depositar, sacar e transferir dinheiro entre contas.

## Estrutura do Projeto

O projeto consiste em várias classes Java:

- `Main.java`: A classe principal que controla o fluxo do programa.
- `Login.java`: Responsável pela autenticação dos usuários.
- `CadastroCliente.java`: Permite que os usuários se registrem.
- `AlteraDadosCliente.java`: Permite que os usuários alterem seus dados de conta.
- `OperacoesBancarias.java`: Implementa as operações bancárias.
- `Clientes.java`: Script para gerar clientes em memória.

## Como Usar

1. Clone este repositório:

```bash
git clone https://github.com/welli7ngton/java-simple-bank-operations.git
```
2. Compile os arquivos Java:
```bash
javac Main.java
```
3. Execute o programa:
```bash
Main.java
```
