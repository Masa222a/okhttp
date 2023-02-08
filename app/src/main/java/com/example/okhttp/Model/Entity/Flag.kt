package com.example.okhttp.Model.Entity

import java.io.Serializable

data class Flag(
    val id: Int,
    val pictureId: Int,
    val name: String?,
    val engName: String?,
    val population: String?,
    val language: String?,
    val capital: String?,
    val currency: String?
): Serializable

enum class flagType(countryCode: Int) {
    //Asia
    India(1),
    Indonesia(2),
    Cambodia(3),
    Singapore(4),
    Srilanka(5),
    Thailand(6),
    Korea(7),
    China(8),
    Nepal(9),
    Pakistan(10),
    Bangladesh(11),
    Timorleste(12),
    Philippines(13),
    Bhutan(14),
    Brunei(15),
    Vietnam(16),
    Malaysia(17),
    Myanmar(18),
    Maldives(19),
    Mongolia(20),
    Laos(21),
    Japan(22),
    Hongkong(23),
    Northkorea(24),
    Taiwan(25),

    //Oceania
    Australia(26),
    Kiribati(27),
    Cookislands(28),
    Samoa(29),
    Solomonislands(30),
    Tuvalu(31),
    Tonga(32),
    Nauru(33),
    Niue(34),
    Newzealand(35),
    Vanuatu(36),
    Papuanewguinea(37),
    Palau(38),
    Fiji(39),
    Marshallislands(40),
    Micronesia(41),

    //NorthAmerica
    Usa(42),
    Canada(43),

    //CentralNorthAmerica
    Argentina(44),
    Antiguabarbuda(45),
    Uruguay(46),
    Ecuador(47),
    Elsalvador(48),
    Guyana(49),
    Cuba(50),
    Guatemala(51),
    Grenada(52),
    Costarica(53),
    Colombia(54),
    Jamaica(55),
    Suriname(56),
    Stkittsnevis(57),
    Stvincentthegrenadines(58),
    Stlucia(59),
    Chile(60),
    Dominica(61),
    Dominicanrepublic(62),
    Trinidadtobago(63),
    Nicaragua(64),
    Haiti(65),
    Panama(66),
    Bahamas(67),
    Paraguay(68),
    Barbados(69),
    Brazil(70),
    Venezuela(71),
    Belize(72),
    Peru(73),
    Bolivia(74),
    Honduras(75),
    Mexico(76),

    //Europe
    Iceland(77),
    Ireland(78),
    Azerbaijan(79),
    Albania(80),
    Armenia(81),
    Andorra(82),
    Italy(83),
    Ukraine(84),
    Uzbekistan(85),
    Unitedkingdom(86),
    Estonia(87),
    Austria(88),
    Netherlands(89),
    Kazakhstan(90),
    Northmacedonia(91),
    Cyprus(92),
    Qreece(93),
    Kyrgyzstan(94),
    Croatia(95),
    Kosovo(96),
    Sanmarino(97),
    Georgia(98),
    Switzerland(99),
    Sweden(100),
    Spain(101),
    Slovakia(102),
    Slovenia(103),
    Serbia(104),
    Tajikistan(105),
    Czechrepublic(106),
    Denmark(107),
    Germany(108),
    Turkmenistan(109),
    Norway(110),
    Vatican(111),
    Hungary(112),
    Finland(113),
    France(114),
    Bulgaria(115),
    Belarus(116),
    Belgium(117),
    Poland(118),
    Bosniaherzegovina(119),
    Portugal(120),
    Malta(121),
    Monaco(122),
    Moldova(123),
    Montenegro(124),
    Latvia(125),
    Lithuania(126),
    Liechtenstein(127),
    Romania(128),
    Luxembourg(129),
    Russia(130),

    //MiddleEast
    Afghanistan(131),
    Uae(132),
    Yemen(133),
    Israel(134),
    Iraq(135),
    Iran(136),
    Oman(137),
    Qatar(138),
    Kuwait(139),
    Saudiarabia(140),
    Syria(141),
    Turkey(142),
    Bahrain(143),
    Jordan(144),
    Lebanon(145),

    //Africa
    Algeria(146),
    Angola(147),
    Uganda(148),
    Egypt(149),
    Eswatini(150),
    Ethiopia(151),
    Eritrea(152),
    Ghana(153),
    Caboverde(154),
    Gabon(155),
    Cameroon(156),
    Gambia(157),
    Guinea(158),
    Guineabissau(159),
    Kenya(160),
    Ivorycoast(161),
    Comoros(162),
    Congo(163),
    Thedemocraticrepubliccongo(164),
    Thedemocraticrepublicofsaotomeandprincipe(165),
    Zambia(166),
    Sierraleone(167),
    Djibouti(168),
    Zimbabwe(169),
    Sudan(170),
    Seychelles(171),
    Equatorialguinea(172),
    Senegal(173),
    Somalia(174),
    Tanzania(175),
    Chad(176),
    Centralafricanrepublic(177),
    Tunisia(178),
    Togo(179),
    Nigeria(180),
    Namibia(181),
    Niger(182),
    Burkinafaso(183),
    Burundi(184),
    Benin(185),
    Botswana(186),
    Madagascar(187),
    Malawi(188),
    Mali(189),
    Southafrica(190),
    Southsudan(191),
    Mauritius(192),
    Mauritania(193),
    Mozambique(194),
    Morocco(195),
    Libya(196),
    Liberia(197),
    Rwanda(198),
    Lesotho(199);

    val urlPath: String
        get() = when(this) {

            //Asia
            India -> "india"
            Indonesia ->"indonesia"
            Cambodia -> "cambodia"
            Singapore -> "singapore"
            Srilanka -> "srilanka"
            Thailand -> "thailand"
            Korea -> "korea"
            China -> "china"
            Nepal -> "nepal"
            Pakistan -> "pakistan"
            Bangladesh -> "bangla"
            Timorleste -> "easttimor"
            Philippines -> "phili"
            Bhutan -> "bhutan"
            Brunei -> "brunei"
            Vietnam -> "vietnam"
            Malaysia -> "malaysia"
            Myanmar -> "myanmar"
            Maldives -> "mol"
            Mongolia -> "mongolia"
            Laos -> "lao"
            Japan -> ""
            Hongkong -> ""
            Northkorea -> ""
            Taiwan -> ""

            //Oceania
            Australia -> "australi"
            Kiribati -> "kili"
            Cookislands -> "cook"
            Samoa -> "samoa"
            Solomonislands -> "solomon"
            Tuvalu -> "toval"
            Tonga -> "tonga"
            Nauru -> "naul"
            Niue -> "niue"
            Newzealand -> "newzea"
            Vanuatu -> "vanu"
            Papuanewguinea -> "papua"
            Palau -> "palau"
            Fiji -> "fiji"
            Marshallislands -> "marshall"
            Micronesia -> "micro"

            //NorthAmerica
            Usa -> "usa"
            Canada -> "canada"

            //CentralNorthAmerica
            Argentina -> "argentin"
            Antiguabarbuda -> "anti"
            Uruguay -> "uruguay"
            Ecuador -> "ecuador"
            Elsalvador -> "elsalvad"
            Guyana -> "giana"
            Cuba -> "cuba"
            Guatemala -> "giana"
            Grenada -> "gure"
            Costarica -> "costa"
            Colombia -> "colombia"
            Jamaica -> "jamaica"
            Suriname -> "suriname"
            Stkittsnevis -> "stc"
            Stvincentthegrenadines -> "stv"
            Stlucia -> "str"
            Chile -> "chile"
            Dominica -> "c_dominica"
            Dominicanrepublic -> "dominica"
            Trinidadtobago -> "trinidad"
            Nicaragua -> "nicaragu"
            Haiti -> "haiti"
            Panama -> "panama"
            Bahamas -> "bahama"
            Paraguay -> "paraguay"
            Barbados -> "bal"
            Brazil -> "brasil"
            Venezuela -> "venezuel"
            Belize -> "beri"
            Peru -> "peruacut"
            Bolivia -> "bolivia"
            Honduras -> "honduras"
            Mexico -> "meacute"

            //Europe
            Iceland -> "iceland"
            Ireland -> "ireland"
            Azerbaijan -> "azerbai"
            Albania -> "albania"
            Armenia -> "almenia"
            Andorra -> "andra"
            Italy -> "italia"
            Ukraine -> "ukraine"
            Uzbekistan -> "uzbeki"
            Unitedkingdom -> "uk"
            Estonia -> "estonia"
            Austria -> "oumlst"
            Netherlands -> "nether"
            Kazakhstan -> "kazakh"
            Northmacedonia -> "maked"
            Cyprus -> "cyplos"
            Qreece -> "greece"
            Kyrgyzstan -> "kilgith"
            Croatia -> "croatia"
            Kosovo -> "kosovo"
            Sanmarino -> "sun"
            Georgia -> "grusia"
            Switzerland -> "suisse"
            Sweden -> "sweden"
            Spain -> "espa"
            Slovakia -> "slova"
            Slovenia -> "slove"
            Serbia -> "yugoslav"
            Tajikistan -> "taji"
            Czechrepublic -> "czech"
            Denmark -> "denmark"
            Germany -> "germany"
            Turkmenistan -> "tolk"
            Norway -> "norway"
            Vatican -> "vatican"
            Hungary -> "hungary"
            Finland -> "finland"
            France -> "france"
            Bulgaria -> "bulgaria"
            Belarus -> "belarus"
            Belgium -> "belgique"
            Poland -> "poland"
            Bosniaherzegovina -> "bosnia"
            Portugal -> "portugal"
            Malta -> "maruta"
            Monaco -> "monaco"
            Moldova -> "mold"
            Montenegro -> "montenegro"
            Latvia -> "latvia"
            Lithuania -> "lithuani"
            Liechtenstein -> "lihi"
            Romania -> "romania"
            Luxembourg -> "luxem"
            Russia -> "russia"

            //MiddleEast
            Afghanistan -> "afga"
            Uae -> "emirates"
            Yemen -> "yemen"
            Israel -> "israel"
            Iraq -> "iraq"
            Iran -> "iran"
            Oman -> "oman"
            Qatar -> "kuwait"
            Kuwait -> "saudi"
            Saudiarabia -> "saudi"
            Syria -> "syria"
            Turkey -> "turkey"
            Bahrain -> "bahrain"
            Jordan -> "jordan"
            Lebanon -> "lebanon"

            //Africa
            Algeria -> "algerie"
            Angola -> "angora"
            Uganda -> "uganda"
            Egypt -> "egypt"
            Eswatini -> "eswatini"
            Ethiopia -> "ethiopia"
            Eritrea -> "elitolia"
            Ghana -> "ghana"
            Caboverde -> "curbo"
            Gabon -> "gabon"
            Cameroon -> "cameroun"
            Gambia -> "ganbia"
            Guinea -> "guina"
            Guineabissau -> "guinabi"
            Kenya -> "kenya"
            Ivorycoast -> "ivoire"
            Comoros -> "comoro"
            Congo -> "congo"
            Thedemocraticrepubliccongo -> "rdcongo"
            Thedemocraticrepublicofsaotomeandprincipe -> "santome"
            Zambia -> "zambia"
            Sierraleone -> "siera"
            Djibouti -> "jibuty"
            Zimbabwe -> "zimbabwe"
            Sudan -> "sudan"
            Seychelles -> "sey"
            Equatorialguinea -> "sekidou"
            Senegal -> "senegal"
            Somalia -> "somaria"
            Tanzania -> "tanzania"
            Chad -> "chard"
            Centralafricanrepublic -> "cafrica"
            Tunisia -> "tunisie"
            Togo -> "togo"
            Nigeria -> "nigeria"
            Namibia -> "nami"
            Niger -> "nijeru"
            Burkinafaso -> "buruki"
            Burundi -> "brundy"
            Benin -> "benan"
            Botswana -> "botuwana"
            Madagascar -> "madagas"
            Malawi -> "maraui"
            Mali -> "mari"
            Southafrica -> "safrica"
            Southsudan -> "s_sudan"
            Mauritius -> "molisi"
            Mauritania -> "moli"
            Mozambique -> "mozanbiq"
            Morocco -> "maroc"
            Libya -> "libya"
            Liberia -> "libelia"
            Rwanda -> "rwanda"
            Lesotho -> "resoto"
        }
}