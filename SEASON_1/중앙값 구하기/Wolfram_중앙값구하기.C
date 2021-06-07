#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAXN ((int)2e4)
int N;
//maxheap
int maxheap[MAXN];
int maxlastn;
int compmax(int a, int b) { return a >= b; }
//minheap
int ans[MAXN];
int minheap[MAXN];
int minlastn;
int compmin(int a, int b) { return a <= b; }

void push(int d, int *heap, int *lastn, int(*comp)(int, int)) {
	heap[++*lastn] = d;
	int C = *lastn, P = C / 2;
	while (P && !comp(heap[P], heap[C])) {
		int tmp = heap[P]; heap[P] = heap[C]; heap[C] = tmp;
		C = P; P = C / 2;
	}
}
int top(int *heap) { 
	return heap[1];
}
void pop(int *heap, int *lastn, int(*comp)(int, int)) {
	heap[1] = heap[(*lastn)--];
	int P = 1, L = 2, R = 3, C;
	while (L <= *lastn) {
		if (R > *lastn) C = L;
		else C = comp(heap[L], heap[R]) ? L : R;
		if (comp(heap[P], heap[C])) break;
		int tmp = heap[P]; heap[P] = heap[C]; heap[C] = tmp;
		P = C; L = P * 2; R = L + 1;
	}
}
void AddHeap(int d) {
	if (top(maxheap) < d) {
		push(d, minheap, &minlastn, compmin);
		if (maxlastn < minlastn) {
			push(top(minheap), maxheap, &maxlastn, compmax);
			pop(minheap, &minlastn, compmin);
		}
	}
	else {
		push(d, maxheap, &maxlastn, compmax);
		if (maxlastn > minlastn + 1) {
			push(top(maxheap), minheap, &minlastn, compmin);
			pop(maxheap, &maxlastn, compmax);
		}
	}
}
void Solve() {
	int t;
	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d", &N);
		int a, b;
		scanf("%d", &a);
		maxlastn = minlastn = 0;
		push(a, maxheap, &maxlastn, compmax); ans[0] = a;
		int idx = 1;
		for (register int i = 0; i < N / 2; i++) {
			scanf("%d %d", &a, &b);
			AddHeap(a); AddHeap(b);
			ans[idx++] = top(maxheap);
		}
		printf("%d\n", idx);
		for (int i = 0; i < idx; i++) {
			if (i > 0 && i % 10 == 0) {
				printf("\n");
			}
			printf("%d ", ans[i]);
		}
		printf("\n");
	}
}
int main() {
	Solve();
	return 0;
}
