A Game of Skill <br>

You and your friend are playing a game on a board with $n + 1$
positions, numbered from $0$
to $n$
. Each of you has a meeple, initially placed at position $0$
, and the goal is to move it to position $n$.
Each of you has a six-sided die, and you take turns to roll your die and move your meeple as many positions forward as the number shown on the die.
If a player is at some position $x$
and rolls an $i$
such that $x + i \geq n$
, their meeple lands on position $n$
and they win. 
You have decided to cheat and have loaded your own die, so the probability of you rolling $i$
is $p_i$
for every $i \in \{1,2,...,6\}$
. Your friend is using a fair die, so, for them, the probability of rolling $i$
is $\frac{1}{6}$
, for every $i \in \{1,2,...,6\}$
.

Your task is to answer the following questions:

1. What is the probability that after you and your friend have played one turn each, your meeples are on the same position, and that position is indexed with an even number?
2. Conditioned on your meeple landing on position $7$
after your second die roll, what is the probability that your meeple landed on position $3$
after your first die roll?
3. Independently of your friend's meeple's behaviour, what is the expected number of die rolls it will take you to reach position $n$
?