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
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/horizontally.png?token=AGMIPIXLATLNZ3BSC2V5GUK7TKYG2"/>

Then it checks if there's a match vertically:
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/vertically.png?token=AGMIPIUC6HB6YDGTOLWDEBS7TKYSM"/>

Then it checks diagonally with a series of steps:

Step 1:
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/step1.png?token=AGMIPIRUJUK5DDJOA3JWOH27TKYUG"/>

Step 2:
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/step2.png?token=AGMIPIXM3SG5UTP2WVZBKUC7TKYUS"/>

Step 3:
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/my%20bad%20this%20is%203.png?token=AGMIPIXXNE2VFTKFSRXQUDS7TKYUW"/>

Step 4:
<img src="https://raw.githubusercontent.com/diowolf/SimianTester/main/src/main/resources/images/step4.png?token=AGMIPIWPGJL55N4D3BIXYRK7TKYU6"/>

During the diagonally check, it's only done if there are more than 4 elements during the iteration. 
Once a match is found it returns true and no longer continues checking.
