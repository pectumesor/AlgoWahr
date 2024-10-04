Neighbourhood Burglary <br>

Everyone from a neighbourhood of $n$
houses placed in a row has left for a week-long vacation. A perfect opportunity for a burglar to strike!

The burglar has a list with the number of valuables each house has inside. He then goes from house to house in order, attempting to break in. 
The first house is old and has almost no security, so the burglar breaks in easily and steals all the valuables inside before continuing to the next house. 
For the rest, it becomes quite a bit more difficult. Suppose the burglar is at the $i$-th house and has collected $v_j$
valuables from the last house he broke into, that is, the $j$-th house for some $j < i$
. Then, depending on the number $v_i$
of valuables inside the $i$-th house, the burglar does one of the following three things:

1. if $v_i < v_j$
, he decides the
$i$-th house is not worth the effort and moves on to the next one;
2. if $v_i \geq v_j$ and $v_i - v_j$  is even, he attempts to break in and succeeds with probability $e_i$
, collecting all the $v_i$
valuables inside, and with probability $1 - e_i$
he fails and moves on to the next house without collecting any valuables;
3. if $v_i \geq v_j$
and $v_i  - v_j$
is odd, he attempts to break in and succeeds with probability $o_i$
, collecting all the $v_i$
valuables inside, and with probability $1 - o_i$
he fails and moves on to the next house without collecting any valuables.
Once the burglar is done with the last house he runs away with whatever loot he managed to collect.

Your task is to answer the following questions:

1. Under the additional assumption that all houses have exactly the same number of valuables inside, what is the expected total number of valuables the burglar runs away with?

2. Conditioned on the burglar breaking into the third house successfully, what is the probability that he broke into the second house as well?
3. What is the expected total number of valuables the burglar runs away with?