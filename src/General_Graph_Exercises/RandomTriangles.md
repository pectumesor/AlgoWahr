Random Triangles <br>

In this exercise you are supposed to examine the random variable denoting the 
number of triangles in a random graph $G \sim G_{n,p}$
.

For $n \in \mathbb{N}$
and $p \in [0,1]$
, we let $G_{n,p}$
denote the probability space of graphs on $n$
vertices where each edge is present with probability $p$
independently of other edges. Let $X$
be the random variable denoting the number of triangles in $G \sim G_{n,p}$
. Compute the expected number of triangles $\mathbb{E}[X]$
and its variance $Var[X]$.

Solution: $\mathbb{E}[X] = \binom{n}{3} \cdot p^3$. Since a triangle are 3 nodes, all connected with each other, with an edge probability of $p$ independant of each other. We then compute for all possible combinations.

For the variance we compute $Var[X] = \mathbb{E}[X^2] - \mathbb{E}[X]^2$. The complicated part is to 
compute $\mathbb{E}[X^2]$, which is to compute all possible cases where 2 triangles is in the graph at the same time. We compute by
case distinction.

Case 1: Both triangles on top of each other: then $\mathbb{E}[X^2] = \mathbb{E}[X]$.<br>Case 2:
The triangles share $2$ vertices, then
$\mathbb{E}[X^2] = \binom{n}{2} \cdot (n-2) \cdot (n-3) \cdot p^5$. This is all combinations of
picking $2$ nodes, then picking $1$ from $n-2$ and $1$ from $n-3$. We will have $5$ edges in the end, thus $p^5$.<br>
Case 3: The triangles share $1$ vertex, then $\mathbb{E}[X^2] = n \cdot 
\binom{n-1}{2} \cdot \binom{n-3}{2} \cdot p^6$, which means we have $n$ ways of picking only $1$ node, then
we pick $2$ from $n-1$ and $2$ from $n-3$. We will have $6$ edges in the end.
Case 4: The triangles share no vertex, then $\mathbb{E}[X^2] = 
\binom n 3 \cdot \binom{n-3}{3} \cdot p^6$, which is trivial.

We then just add all cases to get the variance.