Grand Threft Alligator <br>

As the leader of a large-scale criminal operation, you are organizing the robbery of a zoo, focusing on a single exotic and expensive animal: the alligator.

You have a map of Algoland that consists of $n$
cities and a number of one-directional roads.
Out of these roads, $m$
have a police car with a police officer stationed on them. Each police officer has a suspicion limit
$k$: if he/she sees $k$
cars driving on that road, he/she becomes suspicious and will investigate any car after that.
That is, at most $k$
cars can pass on that road without being stopped by the police. In addition, there are $r$
roads with no police cars stationed on them.

At first, all thieves are in the city of Algoville. Each thief can take a car and drive along some of the roads in Algoland to reach the zoo. At that point, the thief will steal exactly one alligator from the zoo and drive to the headquarters of your criminal organization.

Your task is to compute the maximum number of alligators that the thieves can steal and transport to the headquarters. There is an unlimited number of thieves in Algoville and an unlimited number of alligators at the zoo, and the headquarters can host an unlimited number of thieves and an unlimited number of alligators. Your plan must be such that no thief is ever stopped by the police - on the way to the zoo, the thieves will be transporting the illegal tools for breaking into it.

To make your task simpler, you're guaranteed that there is no non-empty sequence of roads that leads from the zoo back again to the zoo.
Additionally, there is at most one road between each pair of cities: if there is a road from city
$u$ to city $v$
, there is no other road from $u$
to $v$
, and there is no road from $v$
to $u$.

Solution: this exercises can be solved by splitting the problem into
two Max. Flow problems.
1. First we we split the node for Zoo into 2 nodes, zooIn and zooOut.
2. Now the first part of the problem is to find, how many people can reach the zoo without raising police suspision
3. Then we add and edge between zooIn to zooOut with the capacity we found, i.e.: the maximal amount of people we know that can reach the zoo.
4. Now we just compute the maxFlow from zooIn to the headquarters, since the new edge we just added will bottlekneck our flow to the amount of people
manage to reach the zoo, thus our solution has to be <= w/e raeched zooIn.
5. Also, if more people reach the zoo then maxK, i.e.: more people than the police monitors reaches the zoo,
then we have a path to the zoo without police surveillance, thus we can reach unlimited amounts of alligators and become rich.