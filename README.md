# 🚌 Schooler — App de Transporte Escolar

Este projeto é um aplicativo Android simples desenvolvido como trabalho acadêmico para a disciplina de **Desenvolvimento Mobile**.  
O objetivo do aplicativo é fornecer uma ferramenta para que **motoristas de transporte escolar** possam gerenciar seus alunos de forma eficiente.

---

## 🚀 Sobre o Projeto

O **Schooler** (cujo nome de pacote é `projeto_barrinha`) é um aplicativo focado no motorista.  
Ele permite que o usuário (motorista) se **cadastre**, **faça login** e, a partir daí, **gerencie uma lista completa de alunos**.

A funcionalidade central é o **cadastro de alunos** e a capacidade de **visualizá-los e filtrá-los por período** (Manhã/Tarde) diretamente da tela inicial.

---

## ✨ Funcionalidades Principais

### 🔐 Autenticação do Motorista
- Tela de **Registro** para criar conta (Nome, Idade, CNH, Telefone, Email, Senha)
- Tela de **Login** para acessar o aplicativo
- **Persistência de dados** do motorista via `SharedPreferences`
- **Menu lateral** com opção de **Sair (Logout)**

### 👤 Perfil do Motorista
- Tela **"Meus Dados"** onde o motorista pode visualizar e atualizar suas informações a qualquer momento

### 🏠 Dashboard (Tela Inicial)
- Exibe um **resumo dos alunos**
- **Controle de Período:** alterna entre **Manhã** e **Tarde**
- **Contagem Dinâmica:** o card “Total de Alunos” é atualizado automaticamente com base no período selecionado
- **Atalhos rápidos** para “Ver Lista de Alunos” e “Cadastrar Novo Aluno”

### 🧒 Gestão de Alunos (CRUD)
- **Cadastrar (Create):** formulário para adicionar novos alunos  
  → Campos: Nome, Escola, Endereço, Período (Manhã/Tarde), Responsável e Curso  
- **Listar (Read):** tela “Alunos” com todos os alunos cadastrados
- **Atualizar (Update):** formulário pré-preenchido para editar alunos
- **Excluir (Delete):** botão para remover alunos do banco de dados

📦 **Persistência dos dados** dos alunos via `Room Database`

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Kotlin  
- **Arquitetura:** Single-Activity com navegação baseada em Fragmentos  

### ⚙️ Componentes Principais
- **Android Navigation Component:** para gerenciar o fluxo de telas  
- **Room Database:** persistência local robusta  
- **SharedPreferences:** armazenamento simples dos dados do motorista  
- **Coroutines (Kotlin):** operações assíncronas no banco de dados  
- **ViewBinding:** acesso seguro aos componentes de layout  

### 🎨 Componentes de UI
- `DrawerLayout` (Menu lateral)  
- `RecyclerView` (Lista de alunos)  
- `MaterialCardView` e `MaterialButton` (Design moderno para dashboard e formulários)

---

## 🔧 Como Executar

1. Clone este repositório:
   ```bash
     git clone https://github.com/joaovictor2201/schooler.git
   ```
2. Abra o projeto no Android Studio

3. Aguarde o Gradle sincronizar todas as dependências

4. Execute o aplicativo em:
    Um emulador Android (API 27 ou superior), ou
    Um dispositivo físico
