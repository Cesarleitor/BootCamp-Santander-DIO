# Resumo Estruturado: JWT Explicado do Jeito Certo

Este documento serve como um checklist baseado no artigo "JWT Explicado do Jeito Certo: Autenticação Moderna com Spring Boot, React e APIs Seguras". Utilize as caixas de seleção para marcar os conceitos e implementações à medida que você os estuda e aplica.

## 1. O Problema das Implementações Comuns
- [ ] **Reconhecimento do problema:** Muitas aplicações utilizam JWT de forma insegura (sem refresh token, guardando de forma errada, sem expiração adequada).
- [ ] **Fugir do básico:** Evitar colocar em produção códigos copiados de tutoriais rápidos que ignoram segurança.

## 2. Fundamentos do JWT
- [ ] **O que é:** JSON Web Token é um token compacto usado para autenticação, autorização e troca segura de informações.
- [ ] **Estrutura de 3 partes:**
  - [ ] **Header:** Define o algoritmo (ex: HS256) e tipo.
  - [ ] **Payload:** Contém os dados (claims) do usuário, como ID, roles e expiração.
  - [ ] **Signature:** Garante a integridade dos dados.
- [ ] **Regra de Ouro:** O JWT é apenas assinado e não criptografado. **NUNCA** armazene dados sensíveis (senhas, CPF, cartão de crédito) no payload.

## 3. O Fluxo Correto e Seguro
- [ ] O usuário realiza o login e a API valida as credenciais.
- [ ] A API gera e retorna dois tokens: **Access Token** e **Refresh Token**.
- [ ] O frontend armazena os tokens (de forma segura).
- [ ] As requisições à API utilizam o cabeçalho `Authorization: Bearer <token>` com o Access Token.
- [ ] Ao expirar o Access Token, o Refresh Token é enviado para obter um novo Access Token sem pedir login novamente.

## 4. Access Token vs Refresh Token
- [ ] **Access Token:** Deve ter tempo de vida curto (5 a 30 minutos). Isso limita o dano caso o token seja interceptado.
- [ ] **Refresh Token:** Tem vida longa (7 a 30 dias). Serve exclusivamente para renovar a sessão e, em caso de roubo, deve ser revogado.

## 5. Implementação no Backend (Spring Boot)
- [ ] **Dependências:** Adicionar a biblioteca JWT (ex: `jjwt-api`).
- [ ] **Geração:** Definir corretamente a data de expiração e assinar usando uma chave segura.
- [ ] **Validação:** Criar método para dar *parse* no token, validando a assinatura e a validade.
- [ ] **Segurança da Chave:** Garantir que a chave secreta possua tamanho adequado (mínimo de 256 bits para o algoritmo HS256).
- [ ] **Filtro no Spring Security:** Implementar uma classe baseada em `OncePerRequestFilter` para interceptar rotas, validar o JWT e configurar o contexto de segurança.

## 6. Armazenamento no Frontend (React)
- [ ] **O jeito ERRADO:** Salvar o token no `localStorage` (deixa a aplicação vulnerável a ataques XSS, onde scripts maliciosos podem ler o token).
- [ ] **O jeito CERTO:** Utilizar Cookies `httpOnly` (inacessíveis via JavaScript) ou armazenar na memória (estado) com controle da renovação do token.

## 7. Principais Erros para Evitar (Checklist de Prevenção)
- [ ] Token com validade infinita ou exageradamente longa.
- [ ] Falhar ao invalidar (revogar) o refresh token no momento do logout.
- [ ] Armazenar informações sigilosas dentro do JWT.
- [ ] Utilizar chaves secretas fracas (WeakKeyException).

## 8. Arquitetura (Microsserviços vs Monolitos)
- [ ] **Em Microsserviços:** Ideal usar um Auth Service e um API Gateway, permitindo que cada serviço valide o token de forma *stateless* e escalável.
- [ ] **Quando NÃO usar JWT:** Entender que monolitos pequenos ou sistemas internos sem necessidade de escalabilidade extrema podem funcionar perfeitamente (ou melhor) com a clássica sessão baseada em Cookies (stateful).
