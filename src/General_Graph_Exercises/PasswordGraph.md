Reconstructing the Password <br>

We all know that remembering passwords is not easy, but writing down a password on a piece of paper is not secure enough.
That is why you decided to write down your password in an intricate way. 
The password is an $n+2$
characters string $a_1,a_2,...,a_{n+2}$
and you wrote down on $n$
separate papers all the possible three letter continuous substrings:
$a_1a_2a_3,a_2a_3a_4,...,a_na_{n+1}a_{n+2}$
. However, over time you forgot your original password as well 
as the order of the papers containing the three letter substrings. To make things worse, you are not even sure if you did not lose some of the papers.
Although not a perfect check, you want to check if you can construct at least one string out of the papers you have.

Solution: We model the prefixes and sufixes as nodes and the substrings
as edges. Rebuilding the password is equivalent on finding an Eulerial Cycle.