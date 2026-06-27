#include <stdio.h>
#include <string.h>

#define d 256  
#define q 101  


void searchPatterns(char *text, char patterns[][20], int num_patterns, int txt_len, int pat_lens[]) {
    int i, j, k;
    
    for (k = 0; k < num_patterns; k++) {
        int pat_len = pat_lens[k];
        int pat_hash = 0;  
        int txt_hash = 0;  
        int h = 1;
        int found = 0;
    
        for (i = 0; i < pat_len - 1; i++) {
            h = (h * d) % q;
        }

        for (i = 0; i < pat_len; i++) {
            pat_hash = (d * pat_hash + patterns[k][i]) % q;
            txt_hash = (d * txt_hash + text[i]) % q;
        }
        for (i = 0; i <= txt_len - pat_len; i++) {
            if (pat_hash == txt_hash) {
                for (j = 0; j < pat_len; j++) {
                    if (text[i + j] != patterns[k][j])
                        break;
                }
                if (j == pat_len) {
                    printf("%s pattern matched at %d\n", patterns[k], i + 1);
                    found = 1;
                    break;
                }
            }

            if (i < txt_len - pat_len) {
                txt_hash = (d * (txt_hash - text[i] * h) + text[i + pat_len]) % q;
                if (txt_hash < 0)
                    txt_hash = (txt_hash + q);
            }
        }

        if (!found) {
            printf("%s pattern did not match\n", patterns[k]);
        }
    }
}

int main() {
    char text[100];
    int num_patterns, i;
    int pat_lens[10];

    printf("Enter the text: ");
    scanf("%s", text);

    printf("Enter the number of patterns: ");
    scanf("%d", &num_patterns);

    char patterns[num_patterns][20];

    for (i = 0; i < num_patterns; i++) {
        printf("Enter pattern %d: ", i + 1);
        scanf("%s", patterns[i]);
        pat_lens[i] = strlen(patterns[i]);
    }

    int txt_len = strlen(text);

    searchPatterns(text, patterns, num_patterns, txt_len, pat_lens);

    return 0;
}
