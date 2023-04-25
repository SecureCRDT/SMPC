# SMPC Library
<img src="https://img.shields.io/badge/status-research%20prototype-green.svg" />

This project is an open-source Java library that implements the Sharemind protocol suite. Specifically, it includes two main secure multiparty computation (SMPC) protocols over secret shared integers: the `Equality` and `Greater Than or Equal To protocols. Both protocols are secure against a passive adversary.

The library provides a high-level API that abstracts the underlying protocol implementation and party communication. This makes it easy to use for any project that requires SMPC protocol for data processing.

# System Architecture

This project has three main components:

- A **Dealer** that secret shares data for the SMPC protocols.
- A **Player** in the multiparty protocol that abstract the communication between parties.
- The protocol implementation that provides a high-level API for the comparison operations over secret shared data.

The current version of this library only includes the implementation of the Sharemind Protocols for integers and longs. It does not include a network layer and all the communication in done in memory. Therefore, in a realistic deployment, the communication between parties over the network must be done at the application level by implementing a new Player class.

# Getting Started with SMPC

## Dependencies

 - Java 8 or greater
 - Maven

## How to use install?

This library is distributed as a Maven package and can be installed as follows:

```shell
mvn install -DskipTests
```

## How to run a test

This library also comes with a test suite to validate the correctness of the protocols.
To run it, use the following command:

```shell
mvn test
```

You can also choose to run a specific test by providing its class name:


```shell
mvn test -Dtest=pt.uminho.haslab.smpc.sharmind.intProtocols.EqualityTest
```

## Usage

This library can be imported into any Java application as Maven dependency.

```mvn
<dependency>
    <groupId>pt.uminho.haslab</groupId>
    <artifactId>smpc</artifactId>
    <version>1.2.1</version>
</dependency>
```

# Contacts

If you are interested in this project or need support to deploy it, please feel free to reach out to [Rogério Pontes](mailto:rogerio.a.pontes@inesctec.pt).