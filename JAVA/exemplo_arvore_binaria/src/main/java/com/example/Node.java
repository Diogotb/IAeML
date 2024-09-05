package com.example;

class Node {
    int value;
    Node left;
    Node right;

    // construtor
    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    void preOrderTraversal(Node node) {
        // Este método realiza a travessia (ou percurso) em pré-ordem de uma árvore binária.
        // Na travessia em pré-ordem, o nó atual é processado primeiro, seguido pela subárvore esquerda,
        // e depois pela subárvore direita.
    
        if (node != null) {
            // Verifica se o nó atual não é nulo. Se for nulo, significa que não há mais nós para visitar
            // nessa ramificação da árvore, então o método retorna e não faz nada.
    
            System.out.print(node.value + " ");
            // Imprime o valor do nó atual. Este é o primeiro passo na travessia em pré-ordem, onde o nó
            // atual é processado antes de seus filhos.
    
            preOrderTraversal(node.left);
            // Chama o método recursivamente para percorrer a subárvore esquerda do nó atual. 
            // Após processar o nó atual, o próximo nó a ser processado é o nó à esquerda, se existir.
    
            preOrderTraversal(node.right);
            // Chama o método recursivamente para percorrer a subárvore direita do nó atual.
            // Após percorrer toda a subárvore esquerda, o método então se move para a subárvore direita.
        }
    }

    void postOrderTraversal(Node node) {
        // Este método realiza a travessia (ou percurso) em pós-ordem de uma árvore binária.
        // Na travessia em pós-ordem, as subárvores esquerda e direita são processadas primeiro,
        // e só depois o nó atual é processado.
    
        if (node != null) {
            // Verifica se o nó atual não é nulo. Se for nulo, significa que não há mais nós para visitar
            // nessa ramificação da árvore, então o método retorna e não faz nada.
    
            postOrderTraversal(node.left);
            // Chama o método recursivamente para percorrer a subárvore esquerda do nó atual.
            // O método desce pela subárvore esquerda até encontrar um nó folha (um nó sem filhos).
    
            postOrderTraversal(node.right);
            // Chama o método recursivamente para percorrer a subárvore direita do nó atual.
            // Só após a subárvore esquerda ser completamente processada, o método então se move
            // para a subárvore direita.
    
            System.out.print(node.value + " ");
            // Finalmente, depois de processar as subárvores esquerda e direita, o valor do nó atual é impresso.
            // Este é o último passo na travessia em pós-ordem, onde o nó é processado após seus filhos.
        }
    }

    void inOrderTraversal(Node node) {
        // Este método realiza a travessia (ou percurso) em ordem de uma árvore binária.
        // Na travessia em ordem (in-order), a subárvore esquerda é processada primeiro,
        // seguido pelo nó atual, e por último a subárvore direita.
    
        if (node != null) {
            // Verifica se o nó atual não é nulo. Se for nulo, significa que não há mais nós para visitar
            // nessa ramificação da árvore, então o método retorna e não faz nada.
    
            inOrderTraversal(node.left);
            // Chama o método recursivamente para percorrer a subárvore esquerda do nó atual.
            // O método desce pela subárvore esquerda até encontrar um nó folha (um nó sem filhos).
    
            System.out.print(node.value + " ");
            // Após processar a subárvore esquerda, imprime o valor do nó atual.
            // Este é o passo do meio na travessia em ordem, onde o nó atual é processado
            // depois da subárvore esquerda, mas antes da subárvore direita.
    
            inOrderTraversal(node.right);
            // Chama o método recursivamente para percorrer a subárvore direita do nó atual.
            // Depois de processar o nó atual, o método então se move para a subárvore direita.
        }
    }
    
}
