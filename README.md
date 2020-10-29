# Simian Tester

This is an application that tests whether a specific DNA belongs to a Simian (mutant) or a human. 

#### How the API works

This application has been hosted on Amazon AWS and there's one instance running at the url:
```
http://simian-env.eba-2k745cve.us-east-2.elasticbeanstalk.com
```

Testing a DNA:

```
POST /simian
```

```json
{
  "dna": ["CTGAGA", "CTATGC", "TCCTGT", "AGCGTG", "CACCTA", "TCACTG"]
}
```

Constraints:

* DNA should follow appropriate sequence length which is 6 characters.
* Allowed characters: A, T, C, G.

Check statistics and ratio:

```
GET /stats
```

Viewing all registered DNA sequences:

```
GET /dna
```

#### How the DNA tester algorithm works

It checks if there's a match horizontally:
<img src="https://i.imgur.com/xjaCTpq.png"/>

Then it checks if there's a match vertically:
<img src="https://i.imgur.com/ptjb8vE.png"/>

Then it checks diagonally with a series of steps:

Step 1:
<img src="https://i.imgur.com/e1b1Yo5.png"/>

Step 2:
<img src="https://i.imgur.com/DCtDEg4.png"/>

Step 3:
<img src="https://i.imgur.com/DlJBWrk.png"/>

Step 4:
<img src="https://i.imgur.com/ZpqA4bP.png"/>

During the diagonally check, it's only done if there are more than 4 elements during the iteration. 
Once a match is found it returns true and no longer continues checking.
