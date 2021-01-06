package main

import (
	"fmt"
	"math"
)

// This is newtons method to find zero values for real valued functions.
// The formula is
// guess = guess - (guess*guess - x) / (2*guess)
//       = guess - f(x) /f'(x)
// the function in this case is (guess*guess - number) where guess is the initial
// guess of that the root of that number is
// The denominator of is the derivative of the number
// The denominator gives how much adjustment is needed based on the slope of the function
// We keep doing this till the result doesnt change or changes within a certain delta
func Sqrt(x float64) float64 {
	var step int = 1
	var guess float64 = 1
	previousGuess := guess
	for ; ;step += 1 {

		fmt.Println("step", step, "guess", guess)
		guess -= (guess * guess - x) / (2*guess)
		if math.Abs(previousGuess - guess) < 0.0000005 {
			return guess
		}
		previousGuess = guess
	}
}

func main() {
	fmt.Println(Sqrt(454545*454545))
}


