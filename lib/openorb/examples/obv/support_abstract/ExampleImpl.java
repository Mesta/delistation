/*
* Copyright (C) The Community OpenORB Project. All rights reserved.
*
* This software is published under the terms of The OpenORB Community Software
* License version 1.0, a copy of which has been included with this distribution
* in the LICENSE.txt file.
*/
package obv.support_abstract;

public class ExampleImpl extends ExamplePOA
{
    public void print()
    {
        System.out.println( ". " );
        System.out.println( ". I'm a remote operation" );
        System.out.println( ". " );
    }
}
