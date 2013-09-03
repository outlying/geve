package com.antyzero.geve;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 * Author: outlying
 * Date: 03.09.13
 * Time: 13:01
 */
public class UrlBuilderTest {

    /**
     * Test builders
     */

    @Test
    public void testBaseBuilder(){

        String url = UrlBuilder.builderBase().build();

        assertThat( url ).isEqualTo( "https://api.eveonline.com" );
    }

    @Test
    public void testEveBuilder(){

        String url = UrlBuilder.builderEve().build();

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve" );
    }

    /**
     * Test generated URLs
     */

    @Test
    public void testUrlAllianceList(){

        String url = UrlBuilder.urlAllianceList();

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/AllianceList.xml.aspx" );
    }

    @Test
    public void testUrlCertificateTree(){

        String url = UrlBuilder.urlCertificateTree();

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CertificateTree.xml.aspx" );
    }

    @Test
    public void testUrlCharacterID(){

        String url = UrlBuilder.urlCharacterID();

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CharacterID.xml.aspx" );
    }

    @Test
    public void testUrlCharacterIDWithName(){

        String charName = "Gareth Frost";

        String url = UrlBuilder.urlCharacterID( charName );

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CharacterID.xml.aspx?names=Gareth%20Frost" );
    }

    @Test
    public void testUrlCharacterInfo(){

        long testID = 1095077034L;

        String url = UrlBuilder.urlCharacterInfo( 1095077034L );

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CharacterInfo.xml.aspx?characterID=" + testID );
    }

    @Test
    public void testUrlCharacterNameSingleID(){

        long testID = 1234567;

        String url = UrlBuilder.urlCharacterName( testID );

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CharacterName.xml.aspx?IDs=" + testID );
    }

    @Test
    public void testUrlCharacterNameManyIDs(){

        long testID1 = 1234567;
        long testID2 = 2345678;
        long testID3 = 3456789;

        Long[] testIDs = { testID1, testID2, testID3 };

        String url = UrlBuilder.urlCharacterName( testIDs );

        assertThat( url ).isEqualTo( "https://api.eveonline.com/eve/CharacterName.xml.aspx?IDs="
                + testID1 + ","
                + testID2 + ","
                + testID3 );
    }


}
