# election-java-rmi-ibellacn

## Election Java RMI
Aplicação de Eleição em Java utilizando RMI (Remote Method Invocation)

## Autora
Isabella Carine Cruz Nicácio

## Professor
Hugo Bastos de Paula

## Instruções de utilização

1. Compilar todas as classes do projeto;
2. Executar no terminal o código ```rmiregistry```
3. Executar a classe Server (Server.java);
4. Executar a classe Client (Client.java);

Código para compilar
```
rmiregistry
javac src/Server.java
javac src/Client.java
```

Código para executar
```
java -Djava.security.policy=rmi.policy src/Server
java -Djava.security.policy=rmi.policy src/Client
```

*OBS: Necessário executar a classe Server antes de executar o Client.*

Siga as instruções exibidas no console para as operações de votar e lista candidatos, e exibir o resultado do candidato escolhido.

election-java-rmi-ibellacn created by GitHub Classroom


