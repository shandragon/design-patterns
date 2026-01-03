# Padrões de Projetos (design-patterns)

Este repositório contém implementações de vários padrões de projetos (design patterns) em Java. Os padrões de projetos são soluções reutilizáveis para problemas comuns que surgem durante o desenvolvimento de software.

Padrões de projeto são soluções consolidadas para problemas recorrentes que surgem durante a modelagem e o desenvolvimento de softwares orientados a objetos. Eles não são pedaços de código prontos para copiar e colar, mas sim **conceitos gerais** e **"plantas de construção"** que o desenvolvedor pode adaptar para resolver desafios específicos em seu próprio projeto.

Os padrões de projeto são classificados, principalmente, de acordo com sua finalidade ou intenção, sendo organizados em três grandes grupos. A seguir, serão apresentados esses grupos, bem como os respectivos padrões de projeto que os compõem e foram implementados neste repositório:

## Padrões Criacionais

Estes padrões focam nos mecanismos de criação de objetos, abstraindo o processo de instanciação. O objetivo é tornar o sistema independente de como seus objetos são criados e compostos, evitando o acoplamento direto com classes concretas.

## Padrões Estruturais
Lidam com a composição de classes e objetos para formar estruturas maiores e mais complexas. Eles visam garantir que, ao montar essas estruturas, o sistema permaneça flexível e eficiente. Alguns utilizam a herança para compor interfaces, enquanto outros focam na composição de objetos para obter novas funcionalidades em tempo de execução.

## Padrões Comportamentais

Concentram-se nos algoritmos e na atribuição de responsabilidades entre os objetos. Eles não descrevem apenas a estrutura das classes, mas principalmente os padrões de comunicação e o fluxo de controle entre os objetos, facilitando a interação eficiente e o baixo acoplamento.

- **Strategy**: Define uma família de algoritmos, encapsula cada um deles e os torna intercambiáveis. O padrão permite que o algoritmo varie independentemente dos clientes que o utilizam.
- **Observer**: Define uma dependência um-para-muitos entre objetos, de forma que quando um objeto muda de estado, todos os seus dependentes são notificados e atualizados automaticamente.