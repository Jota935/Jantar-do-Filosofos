# Jantar-do-Filosofos
Este projeto implementa uma solução concorrente para o Problema dos Filósofos Jantando, utilizando Semáforos (Semaphore) em Java, garantindo que os filósofos possam alternar entre pensar e comer sem provocar deadlocks.

📚 Descrição do Problema

Existem n filósofos sentados ao redor de uma mesa circular.

Cada filósofo alterna entre os estados de pensar e comer.

Para comer, um filósofo precisa de dois garfos:

Um à sua esquerda

Um à sua direita

Cada garfo é compartilhado entre dois filósofos adjacentes.

O desafio é evitar deadlock e condições de corrida.

🎯 Objetivos do Projeto

Implementar controle de concorrência usando Semaphore

Evitar deadlocks

Permitir escalabilidade (adição/remoção de filósofos)

Exibir logs no console para monitoramento das ações

🛠️ Tecnologias Utilizadas

Java

Threads

java.util.concurrent.Semaphore

🧠 Estratégia de Solução
1️⃣ Semáforo por Garfo

Cada garfo é representado por um Semaphore(1)

Garante que apenas um filósofo utilize o garfo por vez

2️⃣ Semáforo Global (Mesa)

Um semáforo chamado mesa permite no máximo N - 1 filósofos tentando comer simultaneamente

Isso elimina a possibilidade de deadlock

3️⃣ Threads Independentes

Cada filósofo é uma thread

Alterna entre pensar → pegar garfos → comer → soltar garfos

🚫 Garantia de Ausência de Deadlock

O deadlock é evitado pois:

Nunca todos os filósofos podem tentar pegar garfos ao mesmo tempo

Sempre haverá pelo menos um filósofo que consegue obter os dois garfos necessários

▶️ Como Executar o Projeto

Certifique-se de ter o Java JDK 8+ instalado

Compile os arquivos:

javac Main.java Filosofo.java

Execute o programa:

java Main
📈 Escalabilidade

Para alterar o número de filósofos, basta modificar a variável n na classe Main:

int n = 5;

O sistema se ajusta automaticamente.

🖨️ Exemplo de Logs no Console
Filósofo 1 está pensando.
Filósofo 1 pegou o garfo esquerdo.
Filósofo 1 pegou o garfo direito.
Filósofo 1 está comendo.
📁 Estrutura do Projeto
├── Main.java        // Classe principal
├── Filosofo.java   // Thread dos filósofos
└── README.md       // Documentação do projeto
✅ Requisitos Atendidos

✔️ Uso de Semaphore

✔️ Controle de concorrência

✔️ Ausência de deadlocks

✔️ Logs detalhados

✔️ Escalabilidade

👨‍🎓 Contexto Acadêmico

Projeto desenvolvido no âmbito da disciplina de Programação Concorrente, no curso de Engenharia Informática e Sistemas Computacionais.

📌 Possíveis Melhorias Futuras

Interface gráfica

Priorização de filósofos

Estatísticas de tempo de espera

Remoção dinâmica de filósofos em tempo de execução

📖 Problema clássico usado para demonstrar sincronização, exclusão mútua e prevenção de deadlocks.
