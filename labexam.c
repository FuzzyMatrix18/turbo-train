#include <stdio.h>
#include <stdlib.h>
#define MAX 100

typedef struct Node {
    int ver;
    struct Node* nxt;
} Node;

Node* graph[MAX];
int m;

void add(int u, int v) {
    Node* newNode = malloc(sizeof(Node));
    newNode->ver = v;
    newNode->nxt = graph[u];
    graph[u] = newNode;
}

void all(int* indeg, int* vis, int* res, int idx) {
    int flag = 0;
    for (int i = 0; i < m; i++) {
        if (!vis[i] && indeg[i] == 0) {
            vis[i] = 1;
            res[idx] = i;
            for (Node* temp = graph[i]; temp; temp = temp->nxt)
                indeg[temp->ver]--;

            all(indeg, vis, res, idx + 1);

            vis[i] = 0;
            for (Node* temp = graph[i]; temp; temp = temp->nxt)
                indeg[temp->ver]++;
            flag = 1;
        }
    }

    if (!flag && idx == m) {
        for (int i = 0; i < m; i++)
            printf("%d ", res[i]);
        printf("\n");
    }
}

int main() {
    int e, u, v;
    printf("Enter number of vertices: ");
    scanf("%d", &m);

    printf("Enter number of edges: ");
    scanf("%d", &e);

    printf("Enter edges (u v):\n");
    for (int i = 0; i < e; i++) {
        scanf("%d %d", &u, &v);
        add(u, v);
    }

    int indegree[MAX] = {0};
    int visited[MAX] = {0};
    int res[MAX];

    for (int i = 0; i < m; i++)
        for (Node* temp = graph[i]; temp; temp = temp->nxt)
            indegree[temp->ver]++;

    printf("\nAll Topological Sorts:\n");
    allTopSorts(indegree, visited, res, 0);
    return 0;
}
