
//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
/** @author  John Miller
 *  @version 1.2
 *  @date    Thu Jul  9 17:40:18 EDT 2015
 *  @see     LICENSE (MIT style license file).
 */

package scalation

import java.io.File
import java.lang.System.nanoTime

import scala.util.Properties.envOrElse

//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
/** The `util` package contains classes, traits and objects for basic utility
 *  functions.
 */
package object util
{
    /** The file/path separation character: '/' for Linux/Mac, '\' for Windows
     */
    val SEP = File.separator

    /** File system path for input/output data directory
     *  Use 'SCALATION_HOME' environmemnt variable or else current directory "."
     */
    val DATA_DIR = envOrElse ("SCALATION_HOME", ".") + SEP + "data" + SEP

    /** File system path for memory mapped files directory
     *  Use 'SCALATION_HOME' environmemnt variable or else current directory "."
     */
    val MEM_MAPPED_DIR = envOrElse ("SCALATION_HOME", ".") + SEP + "mem_mapped" + SEP

    /** File system path for database storage directory
     *  Use 'SCALATION_HOME' environmemnt variable or else current directory "."
     */
    val STORE_DIR = envOrElse ("SCALATION_HOME", ".") + SEP + "store" + SEP

    /** The number of nanoseconds per millisecond
     */
    val NS_PER_MS = 1E-6

    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /** Print the elapsed time in milliseconds (ms) for the execution of an
     *  arbitrary block of code:  'time { block }'.
     *  @see http://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
     *  @param block  the block of code to be executed
     */
    def time [R] (block: => R): R =
    {
        val t0 = nanoTime ()
        val result = block                       // call-by-name
        val t1 = nanoTime ()
        println ("Elapsed time: " + (t1 - t0) * NS_PER_MS + " ms")
        result
    } // time
    
    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    /** Calculate the elapsed time in milliseconds (ms) for the execution of an
     *  arbitrary block of code:  'time { block }'.
     *  @see http://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
     *  @param block  the block of code to be executed
     */
    def timer [R] (block: => R): (R, Double) = 
    {
        val t0 = nanoTime ()
        val result = block                       // call-by-name
        val t1 = nanoTime ()
        (result, (t1 - t0) * NS_PER_MS)
    } // time

} // util package object 

