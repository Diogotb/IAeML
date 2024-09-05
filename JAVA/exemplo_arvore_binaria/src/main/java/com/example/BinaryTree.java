package com.example;

class BinaryTree {
    Node root; 
    // Declaração de uma variável de instância chamada 'root', que é a raiz da árvore binária.

    int height(Node node) {
        // Este método calcula a altura de um nó na árvore binária.
        // A altura de um nó é definida como o número
        // de arestas no caminho mais longo até uma folha (nó sem filhos).

        if (node == null) {
            return 0;
            // Se o nó for null (ou seja, se a árvore ou subárvore estiver vazia), a altura é 0.
        } else {
            int leftHeight = height(node.left);
            // Recursivamente calcula a altura da subárvore esquerda.

            int rightHeight = height(node.right);
            // Recursivamente calcula a altura da subárvore direita.

            return Math.max(leftHeight, rightHeight) + 1;
            // Retorna a maior altura entre as subárvores esquerda e direita, 
            // adicionando 1 para contar o nó atual.
        }
    }
}
