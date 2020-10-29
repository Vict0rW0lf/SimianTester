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
