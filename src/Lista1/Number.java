package Lista1;

/** A class that represents an immutable natural number. */
class Number
{
	/** An array that maps integer digits to character digits. */
	private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	/** The value of the number. */
	public long value;
	public long getValue()
	{
		return this.value;
	}
	 
	/**
	 * 	Construct the number.
	 * 
	 *	@param v The value of the number. The condition <code>v ≥ 0</code> must hold. 
	 *	@throws IllegalArgumentException Thrown when <code>v ≤ -1</code>.
	 */
	public Number(long v) throws IllegalArgumentException
	{
		// Check whether v is really a natural number.
		if(v < 0)
		{
			throw new IllegalArgumentException(v + " must be a natural number.");
		}
		
		this.value = v;
	}
	
	/**
	 * @param b	The base in which the number is to be represented.
	 * @throws IllegalArgumentException Thrown when <code>b ≤ 1</code> or <code>b ≥ 17</code>.
	 * @return The string representation of <code>this.value</code> in base <code>b</code>.
	 */
	public String inBase(int b) throws IllegalArgumentException
	{
		// Check whether a correct base was specified.
		if(b < 2 || b > 16)
		{
			throw new IllegalArgumentException(b + " must be in the range 2-16.");
		}
		
		// If b = 10 then no conversion needs to be done, as the value of the number is already stored in base ten.
		// Otherwise, convert it to the desired base.
		if(b == 10)
		{
			return Long.toString(this.value);
		}
		else
		{
			// Assign the value to a new variable so that it can be modified.
			long v = this.value;

			// A string that holds the result.
			String result = "";
			
			// Compute the remainder of the division v/b, convert it to a character using the Number.digits array
			// and prepend it to the result. This is a well-known algorithm for converting number between bases.
			do
			{
				result = Number.digits[(int) (v % b)] + result;
				v /= b;
			} while(v != 0);
			
			return result;
		}
	}
}