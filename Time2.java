// Fig. 8.5: Time2.java
// Time2 class declaration with overloaded constructors.  

public class Time2
{
   private int secondFrZero;   // 0 - 86400 second form mid night (zero)
   
   // Time2 no-argument constructor: initializes each instance variable 
   // to zero; ensures that Time2 objects start in a consistent state
   public Time2()
   {
      this( 0); // invoke Time2 constructor with one arguments
   } // end Time2 no-argument constructor

   // Time2 constructor: hour supplied, minute and second defaulted to 0
   public Time2( int h ) 
   { 
		secondFrZero = h*3600; // invoke Time2 constructor with one arguments
   } // end Time2 one-argument constructor

   // Time2 constructor: hour and minute supplied, second defaulted to 0
   public Time2( int h, int m ) 
   { 
      secondFrZero = ( h*60*60 + m*60); // invoke Time2 constructor with one arguments
   } // end Time2 two-argument constructor 

   // Time2 constructor: hour, minute and second supplied
   public Time2( int h, int m, int s ) 
   { 
      setTime( h, m, s ); // invoke setTime to validate time
   } // end Time2 three-argument constructor 

   // Time2 constructor: another Time2 object supplied
   public Time2( Time2 time )
   {
      // invoke Time2 three-argument constructor
      setTime( time.getHour(), time.getMinute(), time.getSecond() );
   } // end Time2 constructor with a Time2 object argument

   // Set Methods
   // set a new time value using universal time; ensure that 
   // the data remains consistent by setting invalid values to zero
   public void setTime( int h, int m, int s )
   {
      secondFrZero = h*3600 + m*60 + s;
   } // end method setTime

   // validate and set hour 
   public void setHour( int h ) 
   { 
      secondFrZero = ( ( h >= 0 && h < 24 ) ? h : 0 )*3600 + secondFrZero%3600; 
   } // end method setHour

   // validate and set minute 
   public void setMinute( int m ) 
   { 
      secondFrZero = ( ( m >= 0 && m < 60 ) ? m : 0 )*60 + (secondFrZero - ((secondFrZero%3600)/60)*60); 
   } // end method setMinute

   // validate and set second 
   public void setSecond( int s ) 
   { 
      secondFrZero = ( ( s >= 0 && s < 60 ) ? s : 0 ) + (secondFrZero/60)*60; 
   } // end method setSecond

   // Get Methods
   // get hour value
   public int getHour() 
   { 
      return secondFrZero/3600; 
   } // end method getHour

   // get minute value
   public int getMinute() 
   { 
      return (secondFrZero%3600)/60; 
   } // end method getMinute

   // get second value
   public int getSecond() 
   { 
      return secondFrZero%60; 
   } // end method getSecond

   // convert to String in universal-time format (HH:MM:SS)
   public String toUniversalString()
   {
      return String.format( 
         "%02d:%02d:%02d", getHour(), getMinute(), getSecond() );
   } // end method toUniversalString

   // convert to String in standard-time format (H:MM:SS AM or PM)
   public String toString()
   {
      return String.format( "%d:%02d:%02d %s", 
         ( (getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12 ),
         getMinute(), getSecond(), ( getHour() < 12 ? "AM" : "PM" ) );
   } // end method toString
} // end class Time2

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/