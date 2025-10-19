# 📱 Teste Técnico Android (Jetpack Compose + MVVM)
## 🎯 Objetivo:
Criar um app bancário simples com 2 telas utilizando Kotlin, Jetpack Compose e MVVM, consumindo APIs REST fornecidas.

- **Avaliar:**
  - **Estrutura e legibilidade do projeto.**
  - **Uso correto de Jetpack Compose.**
  - **Integração com APIs REST.**
  - **Navegação entre telas.**
  - **Boas práticas em arquitetura (MVVM).**
  - **Gerenciamento de estado.**
  - **Boas práticas visuais.**
 
# 🖼️ Telas a serem construídas:
![Image](https://github.com/user-attachments/assets/5c9b082b-6df5-45d2-b1b6-b8ba33577901)

# 1️⃣ Tela de Login:
- **Funcionalidades:**
  - **Exibir o logo da empresa**
  - **Campo de Email:**
    - **Validar se o email é válido antes de permitir login.**
    - **Regra de validação: o email deve conter “@” para ser considerado válido.**
    - **Exibir mensagem de erro clara caso o email seja inválido.**
 - **Campo de Senha:**
     - **Validar se a senha tem no mínimo 6 caracteres, contendo pelo menos 1 letra e 1 número.**
     - **Exibir mensagem de erro caso a senha seja inválida.**
 - **Botão de Login:**
     - **Permanece desabilitado até que o email e a senha estejam válidos.**
     - **Ao clicar:**
       - **Chama a API para buscar os dados do cliente.**
       - **Navega para a tela de Pagamentos ao sucesso.**


- **API:**
  - **Endpoint:**
     ```
       GET https://60bd336db8ab3700175a03b3.mockapi.io/treinamento/Login
     ```
  - **Response:**
     ```
       [
          {
            "customerName": "Tech Coach",
            "accountNumber": "30511-100",
            "branchNumber": "9999",
            "checkingAccountBalance": 12,
            "id": "1"
          }
      ]
     ```

# 2️⃣ Tela de Pagamentos:
- **Funcionalidades:**
  - **Exibir o título ```“Pagamentos”``` no topo.**
  - **Mostrar os detalhes do cliente:**
    - **Nome.**
    - **Agência.**
    - **Conta.**
    - **Saldo.**
  - **Título: ```“Contas pagas”```.**
  - **Listar as contas pagas:**
    - **Nome fixo: ```“Conta de luz”```.**
    - **Valor do pagamento.**
    - **Data do pagamento alinhada à direita.**
  - **Exibir loading enquanto carrega os dados.**
  - **Exibir mensagem de erro em caso de falha de carregamento.**


- **API:**
  - **Endpoint:**
     ```
       GET https://60bd336db8ab3700175a03b3.mockapi.io/treinamento/payments
     ```
  - **Response:**
     ```
       [
          {
            "paymentDate": "12/12/2020",
            "electricityBill": "R$ 1.000,00",
            "id": "1"
          }
      ]
     ```
