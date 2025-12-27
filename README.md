# 📦 CalcFrete - Calculadora de Frete

API REST desenvolvida em Java com Spring Boot para cálculo de valores de frete baseado em peso, distância e tipo de entrega.

## 📋 Sobre o Projeto

O **CalcFrete** é uma aplicação Spring Boot que fornece uma API RESTful para calcular custos de frete.  O sistema suporta dois tipos de envio: 
- **Standard** (Padrão): Entrega com custo reduzido
- **Express** (Expressa): Entrega rápida com custo adicional

A aplicação utiliza o padrão Strategy para implementar diferentes algoritmos de cálculo de frete, tornando o código extensível e fácil de manter.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Web** - Para criação de APIs REST
- **Maven** - Gerenciamento de dependências
- **JUnit 5** - Testes unitários

## ⚙️ Pré-requisitos

Antes de começar, você precisará ter instalado: 

- [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) ou superior
- [Maven 3.6+](https://maven.apache.org/download.cgi) (opcional, o projeto inclui Maven Wrapper)

## 📦 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/matalvesdev/calcula-frete.git
cd calcula-frete
```

### 2. Compile o projeto

**Usando Maven Wrapper (recomendado):**

```bash
# Linux/Mac
./mvnw clean install

# Windows
mvnw. cmd clean install
```

**Usando Maven instalado:**

```bash
mvn clean install
```

### 3. Execute a aplicação

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw. cmd spring-boot:run
```

A aplicação estará disponível em:  `http://localhost:8080`

## 💻 Uso da API

### Endpoint:  Calcular Frete

**GET** `/shipping/calculate`

#### Parâmetros de Query

| Parâmetro  | Tipo     | Descrição                                    | Valores Aceitos          |
|-----------|----------|----------------------------------------------|--------------------------|
| `type`    | String   | Tipo de envio                                | `standard` ou `express`  |
| `weight`  | Double   | Peso do pacote em quilogramas (kg)           | Valor positivo           |
| `distance`| Double   | Distância em quilômetros (km)                | Valor positivo           |

#### Exemplos de Requisição

**Frete Padrão:**
```bash
curl "http://localhost:8080/shipping/calculate?type=standard&weight=5. 0&distance=100.0"
```

**Frete Expresso:**
```bash
curl "http://localhost:8080/shipping/calculate?type=express&weight=5.0&distance=100.0"
```

#### Resposta de Sucesso (200 OK)

```json
{
  "shippingCost": 55.0
}
```

### Fórmulas de Cálculo

**Frete Padrão (Standard):**
```
custo = (peso × 1.0) + (distância × 0.5)
```

**Frete Expresso (Express):**
```
custo = (peso × 1.5) + (distância × 0.75)
```

## 🏗️ Estrutura do Projeto

```
calcula-frete/
├── src/
│   ├── main/
│   │   ├── java/matalvesdev/CalcFrete/
│   │   │   ├── controller/
│   │   │   │   ├── ShippingController.java       # Controlador REST
│   │   │   │   └── dto/
│   │   │   │       └── ShippingResponse.java     # DTO de resposta
│   │   │   ├── service/
│   │   │   │   └── ShippingService.java          # Lógica de negócio
│   │   │   ├── domain/
│   │   │   │   ├── ShippingCalculator. java       # Interface Strategy
│   │   │   │   ├── StandardShippingCalculator.java
│   │   │   │   └── ExpressShippingCalculator.java
│   │   │   └── CalcFreteApplication.java         # Classe principal
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/matalvesdev/CalcFrete/
│           └── CalcFreteApplicationTests.java
├── pom. xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🧪 Executando os Testes

```bash
# Executar todos os testes
./mvnw test

# Com relatório de cobertura
./mvnw test jacoco:report
```

## 🎯 Padrões de Design Utilizados

### Strategy Pattern
O projeto utiliza o padrão **Strategy** para implementar diferentes algoritmos de cálculo de frete: 

- `ShippingCalculator` - Interface que define o contrato
- `StandardShippingCalculator` - Implementação para frete padrão
- `ExpressShippingCalculator` - Implementação para frete expresso

Isso permite adicionar novos tipos de frete facilmente sem modificar o código existente (Princípio Open/Closed - SOLID).

## 🔧 Configuração

O projeto usa as configurações padrão do Spring Boot.  Para personalizar, edite o arquivo `src/main/resources/application.properties`:

```properties
# Exemplo:  alterar a porta do servidor
server.port=8081
```

## 📝 Dependências Principais

Conforme definido no `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Web para APIs REST -->
    <dependency>
        <groupId>org. springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring Boot Test para testes -->
    <dependency>
        <groupId>org. springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 🚀 Deploy

### Gerar JAR executável

```bash
./mvnw clean package
```

O arquivo JAR será gerado em:  `target/CalcFrete-0.0.1-SNAPSHOT. jar`

### Executar o JAR

```bash
java -jar target/CalcFrete-0.0.1-SNAPSHOT. jar
```

## 👤 Autor

**matalvesdev**

- GitHub: [@matalvesdev](https://github.com/matalvesdev)
- Repository: [calcula-frete](https://github.com/matalvesdev/calcula-frete)


## 📚 Recursos Adicionais

- [Documentação Spring Boot](https://docs.spring.io/spring-boot/index.html)
- [Spring Web Guide](https://spring.io/guides/gs/rest-service/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)
