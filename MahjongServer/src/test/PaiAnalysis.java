//
///////////////////////////////////////////////////////////////////////////////
//// 建 立 者: Vincent
////
//// 建立日期: 2009/06/05
////
//// 維 護 者: Vincent
////
//// 最後修改:  
////
//// 說    明:
////  1. 13張麻將台型分析，回傳各牌型各組合的符合數0-14
//import java.io.*;
//import java.util.*;
//import android.app.Activity;
//import android.content.res.Configuration;
//import android.os.Bundle;
//import android.view.*;
//import au.*;
//import co.*;
//import gm.*;
//import ui.*;
//import ut.*;
//
//public class PaiAnalysis
//{
//
//    public final static int DaSiXi                  = 0;//大四喜
//    public final static int DaSanYuan               = 1;//大三元
//    public final static int LuYiShai                = 2;//綠一色
//    public final static int JiuLianBaoDeng          = 3;//九蓮寶燈
//    public final static int SiGang                  = 4;//四槓
//    public final static int LianQiDui               = 5;//連七對
//    public final static int ShiSanYao               = 6;//十三么
//    public final static int QingYaoJiu              = 7;//清么九
//    public final static int XiaoSiXi                = 8;//小四喜
//    public final static int XiaoSanYuan             = 9;//小三元
//    public final static int ZiYiShai                = 10;//字一色
//    public final static int SiAnKe                  = 11;//四暗刻
//    public final static int YiShaiShuangLongHui     = 12;//一色雙龍會
//    public final static int YiShaiSiTongShun        = 13;//一色四同順
//    public final static int YiShaiSiJieGao          = 14;//一色四節高
//    public final static int HunYaoJiu               = 15;//混么九
//    public final static int YiShaiSiBuGao           = 16;//一色四步高
//    public final static int SanGang                 = 17;//三槓
//    public final static int QiDui                   = 18;//七對
//    public final static int QiXingBuKao             = 19;//七星不靠
//    public final static int QuanShuangKe            = 20;//全雙刻
//    public final static int QingYiShai              = 21;//清一色
//    public final static int YiShaiSanTongShun       = 22;//一色三同順
//    public final static int YiShaiSanJieGao         = 23;//一色三節高
//    public final static int QuanDai                 = 24;//全大
//    public final static int QuanZhong               = 25;//全中
//    public final static int QuanXiao                = 26;//全小
//    public final static int QingLong                = 27;//清龍
//    public final static int SanShaiShuangLongHui    = 28;//三色雙龍會
//    public final static int YiShaiSanBuGao          = 29;//一色三步高
//    public final static int QuanDaiWu               = 30;//全帶五
//    public final static int SanTongKe               = 31;//三同刻
//    public final static int SanAnKe                 = 32;//三暗刻
//    public final static int QuanBuKao               = 33;//全不靠
//    public final static int ZuHeLong                = 34;//組合龍
//    public final static int DaiYuWu                 = 35;//大於五
//    public final static int XiaoYuWu                = 36;//小於五
//    public final static int SanFengKe               = 37;//三風刻
//    public final static int HuaLong                 = 38;//花龍
//    public final static int TuiBuDao                = 39;//推不倒
//    public final static int SanShaiSanTongShun      = 40;//三色三同順
//    public final static int SanShaiSanJieGao        = 41;//三色三節高
//    public final static int WuFanHe                 = 42;//無番和
//    public final static int MiaoShouHuiChun         = 43;//妙手回春
//    public final static int HaiDiLaoYue             = 44;//海底撈月
//    public final static int GangShangKaiHua         = 45;//槓上開花
//    public final static int QiangGangHe             = 46;//搶槓和
//    public final static int PengPengHe              = 47;//碰碰和
//    public final static int HunYiShai               = 48;//混一色
//    public final static int SanShaiSanBuGao         = 49;//三色三步高
//    public final static int WuMenQi                 = 50;//五門齊
//    public final static int QuanQiuRen              = 51;//全求人
//    public final static int ShuangAnGang            = 52;//雙暗槓
//    public final static int ShuangJianKe            = 53;//雙箭刻
//    public final static int QuanDaiYao              = 54;//全帶么
//    public final static int BuQiuRen                = 55;//不求人
//    public final static int ShuangMingGang          = 56;//雙明槓
//    public final static int HeJueZhang              = 57;//和絕張
//    public final static int JianKe                  = 58;//箭刻
//    public final static int QuanFengKe              = 59;//圈風刻
//    public final static int MenFengKe               = 60;//門風刻
//    public final static int MenQianQing             = 61;//門前清
//    public final static int PingHe                  = 62;//平和
//    public final static int SiQuiYi                 = 63;//四歸一
//    public final static int ShuangTongKe            = 64;//雙同刻
//    public final static int ShuangAnKe              = 65;//雙暗刻
//    public final static int AnGang                  = 66;//暗槓
//    public final static int DuanYao                 = 67;//斷么
//    public final static int YiBanGao                = 68;//一般高
//    public final static int XiXiangFeng             = 69;//喜相逢
//    public final static int LianLu                  = 70;//連六
//    public final static int LaoShaoFu               = 71;//老少副
//    public final static int YaoJiuKe                = 72;//么九刻
//    public final static int MingGang                = 73;//明槓
//    public final static int QueYiMen                = 74;//缺一門
//    public final static int WuZi                    = 75;//無字
//    public final static int BianZhang               = 76;//邊張
//    public final static int KanZhang                = 77;//坎張
//    public final static int DanDiaoJiang            = 78;//單釣將
//    public final static int ZiMo                    = 79;//自摸
//    public final static int HuaPai                  = 80;//花牌
//	
//    public static int quanFeng                      = 0;//圈風0-3
//    public static int menFeng                       = 0;//門風0-3
//	
//	public static int TEST_JU                       = 1;
//	public static int TEST_HE                       = 0;
//	
//	public static int[] hu = new int[14];//IsHuPai 用的陣列，若胡牌，此陣列會依3332形式排好，且不會改變chiPeng指針之前的牌
//	public static int[] pai = new int[14];//IsHuPai 用的陣列，要檢查的原始陣列
//	
//	public final static int[] FanShu =   
//	                        {     //各牌型番數
//	                            88,88,88,88,88,88,88,64,64,64,//0-9
//								64,64,64,48,48,32,32,32,24,24,//10-19
//								24,24,24,24,24,24,24,16,16,16,//20-29
//								16,16,16,12,12,12,12,12, 8, 8,//30-39
//								 8, 8, 8, 8, 8, 8, 8, 6, 6, 6,//40-49
//								 6, 6, 8, 6, 4, 4, 4, 4, 2, 2,//50-59
//								 2, 2, 2, 2, 2, 2, 2, 2, 1, 1,//60-69
//								 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,//70-79
//								 1,//80
//	                        };
//	public final static int[][] BuJi=
//	                        {//各牌型不計清單，index=上方代號，EX：55不求人不計61門清79自摸，-1表示無
//							    {SanFengKe,PengPengHe,QuanFengKe,MenFengKe},//0
//								{JianKe,ShuangJianKe},
//								{-1},
//								{QingYiShai},
//								{PengPengHe,DanDiaoJiang,SanGang,ShuangAnGang,ShuangMingGang,AnGang,MingGang},//槓牌相關番數全不計
//								{QiDui,QingYiShai,PingHe},//5
//								{WuMenQi,QuanDaiYao,DanDiaoJiang},
//								{QuanDaiYao,PengPengHe,YaoJiuKe,ShuangTongKe,WuZi},
//								{SanFengKe},
//								{JianKe,ShuangJianKe},
//							    {QuanDaiYao,PengPengHe},//10
//								{PengPengHe},
//								{QiDui,QingYiShai,PingHe,LaoShaoFu},
//								{YiShaiSanTongShun,YiShaiSanJieGao,SiQuiYi,YiBanGao},
//								{YiShaiSanTongShun,YiShaiSanJieGao,PengPengHe},
//								{QuanDaiYao,PengPengHe,YaoJiuKe},//15
//								{YiShaiSanBuGao,LianLu,LaoShaoFu},
//								{ShuangAnGang,ShuangMingGang,AnGang,MingGang},//3槓牌以下相關番數全不計
//								{DanDiaoJiang,QuanDaiYao},//新增不計QuanDaiYao，因為目前檢查方式會算到全帶么，所以要排除
//								{WuMenQi,DanDiaoJiang,QuanDaiYao},//新增不計QuanDaiYao，因為目前檢查方式會算到全帶么，所以要排除
//							    {PengPengHe,DuanYao},//20
//								{-1},
//								{YiShaiSanJieGao,YiBanGao},
//								{YiShaiSanTongShun},
//								{DaiYuWu,WuZi},
//								{DuanYao},//25
//								{XiaoYuWu,WuZi},
//								{LaoShaoFu},
//								{PingHe,XiXiangFeng,LaoShaoFu,WuZi},
//								{-1},
//							    {DuanYao},//30
//								{-1},
//								{-1},
//								{WuMenQi,DanDiaoJiang,QuanDaiYao},//新增不計QuanDaiYao，因為目前檢查方式會算到全帶么，所以要排除
//								{-1},
//								{WuZi},//35
//								{WuZi},
//								{-1},
//								{-1},
//								{QueYiMen},
//							    {-1},//40
//								{-1},
//								{-1},
//								{ZiMo},
//								{-1},
//								{ZiMo},//45
//								{HeJueZhang},
//								{-1},
//								{-1},
//								{-1},
//							    {-1},//50
//								{DanDiaoJiang},
//								{-1},
//								{JianKe},
//								{-1},
//								{MenQianQing,ZiMo},//55
//								{-1},
//								{QiangGangHe},
//								{-1},
//								{-1},
//							    {-1},//60
//								{-1},
//								{WuZi},
//								{-1},
//								{-1},
//								{-1},//65
//								{-1},
//								{WuZi},
//								{-1},
//								{-1},
//							    {-1},//70
//								{-1},
//								{-1},
//								{-1},
//								{-1},
//								{-1},//75
//								{-1},
//								{-1},
//								{-1},
//								{-1},
//								{-1},//80
//							};
//	
//	public final static String[] wordx =
//	                        {
//							    "一萬","二萬","三萬","四萬","五萬","六萬","七萬","八萬","九萬","空牌",//0-9
//								"一筒","二筒","三筒","四筒","五筒","六筒","七筒","八筒","九筒","空牌",//10-19
//								"一條","二條","三條","四條","五條","六條","七條","八條","九條","空牌",//20-29
//								"東風","南風","西風","北風","紅中","青發","白板","空牌","空牌","空牌",//30-39
//								"春花","夏花","秋花","冬花","梅花","蘭花","竹花","菊花","空牌","空牌",//40-49
//							};
//	public final static String[] word =
//	                        {
//							    "1wan","2wan","3wan","4wan","5wan","6wan","7wan","8wan","9wan","spaceCard",//0-9
//								"1tong","2tong","3tong","4tong","5tong","6tong","7tong","8tong","9tong","spaceCard",//10-19
//								"1tiau","2tiau","3tiau","4tiau","5tiau","6tiau","7tiau","8tiau","9tiau","spaceCard",//20-29
//								"EAST","SOUTH","WEST","NORTH","RED","GREEN","WHITE","spaceCard","spaceCard","spaceCard",//30-39
//								"1flower","2flower","3flower","4flower","5flower","6flower","7flower","8flower","spaceCard","spaceCard",//40-49
//							};
//	public final static String[] Fan =
//	                        {
//							    "四風會","大三元","綠一色","九蓮寶燈","四槓",//0-4
//							    "連七對","十三么","清么九","小四風會","小三元",//5-9
//							    "字一色","四暗刻","一色雙龍會","一色四同順","一色四節高",//10-14
//							    "混么九","一色四步高","三槓","七對","七星不靠",//15-19
//							    "全雙刻","清一色","一色三同順","一色三節高","全大",//20-24
//							    "全中","全小","清龍","三色雙龍會","一色三步高",//25-29
//							    "全帶五","三同刻","三暗刻","全不靠","組合龍",//30-34
//							    "大於五","小於五","三風刻","花龍","推不倒",//35-39
//							    "三色三同順","三色三節高","無番和","妙手回春","海底撈月",//40-44
//							    "槓上開花","搶槓和","碰碰和","混一色","三色三步高",//45-49
//							    "五門齊","全求人","雙暗槓","雙箭刻","全帶么",//50-54
//							    "不求人","雙明槓","和絕張","箭刻","圈風刻",//55-59
//							    "門風刻","門前清","平和","四歸一","雙同刻",//60-64
//							    "雙暗刻","暗槓","斷么","一般高","喜相逢",//65-69
//							    "連六","老少副","么九刻","明槓","缺一門",//70-74
//							    "無字","邊張","坎張","單釣將","自摸",//75-79
//							    "花牌",//80
//							};
//							
//	public final static String[] FanE =
//	                        {
//							    "DaSiXi","DaSanYuan","LuYiShai","JiuLianBaoDeng","SiGang",//0-4
//							    "LianQiDui","ShiSanYao","QingYaoJiu","XiaoSiXi","XiaoSanYuan",//5-9
//							    "ZiYiShai","SiAnKe","YiShaiShuangLongHui","YiShaiSiTongShun","YiShaiSiJieGao",//10-14
//							    "HunYaoJiu","YiShaiSiBuGao","SanGang","QiDui","QiXingBuKao",//15-19
//							    "QuanShuangKe","QingYiShai","YiShaiSanTongShun","YiShaiSanJieGao","QuanDai",//20-24
//							    "QuanZhong","QuanXiao","QingLong","SanShaiShuangLongHui","YiShaiSanBuGao",//25-29
//							    "QuanDaiWu","SanTongKe","SanAnKe","QuanBuKao","ZuHeLong",//30-34
//							    "DaiYuWu","XiaoYuWu","SanFengKe","HuaLong","TuiBuDao",//35-39
//							    "SanShaiSanTongShun","SanShaiSanJieGao","WuFanHe","MiaoShouHuiChun","HaiDiLaoYue",//40-44
//							    "GangShangKaiHua","QiangGangHe","PengPengHe","HunYiShai","SanShaiSanBuGao",//45-49
//							    "WuMenQi","QuanQiuRen","ShuangAnGang","ShuangJianKe","QuanDaiYao",//50-54
//							    "BuQiuRen","ShuangMingGang","HeJueZhang","JianKe","QuanFengKe",//55-59
//							    "MenFengKe","MenQianQing","PingHe","SiQuiYi","ShuangTongKe",//60-64
//							    "ShuangAnKe","AnGang","DuanYao","YiBanGao","XiXiangFeng",//65-69
//							    "LianLu","LaoShaoFu","YaoJiuKe","MingGang","QueYiMen",//70-74
//							    "WuZi","BianZhang","KanZhang","DanDiaoJiang","ZiMo",//75-79
//							    "HuaPai",//80
//							};
//							
//	public static int[] checkOnece_14 = {//有符合數的14張牌型，需依難易度調整順序，簡單的放前面
//										 //混一色,全求人,碰碰和,七對,清一色,三色雙龍會,全不靠,大於五,小於五,混么九,推不倒,綠一色,十三么,字一色,一色雙龍會,
//										   48,51,47,18,21,28,33,35,36,15,39,2,6,10,12,
//										};
//	public static int[] checkOnece_9 =  {//有符合數的9張牌型，需依難易度調整順序，簡單的放前面
//										 //三色三步高,三色三同順,花龍,清龍,三色三節高,三風刻,一色三步高,一色三同順,一色三節高
//										   49,40,38,27,41,37,29,22,23,
//										};
//	
//	public static int[] checkOften =    {//1或0 的牌型，每次進牌時檢查
//										 //五門齊,箭刻,圈風刻,門風刻,門前清,四歸一,雙同刻,雙暗刻,暗槓,斷么,一般高,喜相逢,連六,老少副,么九刻,明槓,缺一門,無字
//										   50,58,59,60,61,63,64,65,66,67,68,69,70,71,72,73,74,75,
//										};
//										
//	public static int[] checkOftenS =    {//可能複數存在的牌型，存在時檢查有幾個
//										 //四歸一,一般高,喜相逢,連六,老少副,么九刻,
//										   63,68,69,70,71,72,
//										};
//										
//	//有前置的牌型，一開始不用檢查，等前置存在再檢查
//	//大四喜,大三元,四槓,連七對,清么九,小四喜,小三元,四暗刻,一色四同順,一色四節高,一色四步高,三槓,七星不靠,全雙刻,全大,全中,全小,三同刻,三暗刻,雙暗槓,雙箭刻,雙明槓,九蓮寶燈,
//	//0,1,4,5,7,8,9,11,13,14,16,17,19,20,24,25,26,31,32,52,53,56,3,
//										
//	public static int[][] checkLater =  {//有前置的牌型，一開始不用檢查，等前置[x][0]存在再檢查
//										   {37, 8, 0},//三風刻,小四喜,大四喜,
//										   {58,53, 9, 1},//箭刻,雙箭刻,小三元,大三元,
//										   {73,56,17, 4},//明槓,雙明槓,三槓,四槓,
//										   {66,52,17, 4},//,暗槓,雙暗槓,三槓,四槓,
//										   {65,32,11},//雙暗刻,三暗刻,四暗刻,
//										   {64,31},//雙同刻,三同刻,
//										   {18, 5},//七對,連七對,
//										   {15, 7},//混么九,清么九,
//										   {22,13},//一色三同順,一色四同順,
//										   {23,14},//一色三節高,一色四節高,
//										   {29,16},//一色三步高,一色四步高,
//										   {33,19},//全不靠,七星不靠,
//										   {47,20},//碰碰和,全雙刻,
//										   {35,24},//大於五,全大,
//										   {30,25},//全帶五,全中,
//										   {36,26},//小於五,全小,
//										   {21, 3},//清一色,九蓮寶燈,
//										};
//										
//	public static int[] checkIfHu =     {//胡牌後再檢查的牌型，主類別中呼叫，此處單純為了比較
//									     //妙手回春,海底撈月,槓上開花,搶槓和,全帶么,不求人,和絕張,平和,邊張,坎張,單釣將,自摸.全帶五,//無番和：最後檢查
//										   43,44,45,46,54,55,57,62,76,77,78,79,30,//42,
//										};
//										
//	public static int[] specialType =   {//非3332的特殊牌型
//	                                     //連七對,十三么,七對,七星不靠,全不靠,組合龍
//										   5,6,18,19,33,34,
//										};
//
//	public static String intToWord( int pai )
//	{
//	    String str = "牌序號錯誤："+pai;
//		if( pai==99 ) str = "無牌";
//		if( pai==-10 ) str = "明槓";
//		if( pai==-11 ) str = "暗槓";
//		if( pai==-1 ) str = "此牌已被消除";
//	    if( pai>49 || pai<0 ) return str;
//		else
//	    return word[pai];
//	}
//	
//	public static void initWind()//初始化風位資訊
//	{
//	    quanFeng = 0;
//		menFeng = 0;
//	}
//	
//	
//	/**回傳該牌陣列是否有不是<萬筒條字>的牌
// 	*@param pai 要檢查的牌陣列
// 	*@return 是否存在
// 	*/
//	private static boolean checkExPai( int[] pai )
//	{
//	    for( int i=0; i<pai.length; i++ )
//		    {
//			    if( pai[i] > 36 ) return true;
//			}
//			
//		return false;
//	}
//	
//	/**回傳該牌陣列在該牌型之最高符合數
//	*@param player for MemFengKe
// 	*@param info[][] 玩家手牌資訊三維陣列，EX：[ 4 = 萬筒條字 ] [ 4 = 總表+順表+單缺表+順缺表 ] [1-12各項資料]
// 	*@param source[] 要檢查的牌陣列
// 	*@param chiPeng 吃碰指針
// 	*@param target 要檢查的目標牌型，EX：PaiAnalysis.YiShaiSanBuGao(  一色三步高 )
// 	*@param IsHu 是否是胡牌後的檢查，若是，部分檢查如碰碰和，會簡化許多
// 	*@return num[] 0.最高符合數(上限14)、1-14廢牌、15-28：缺的牌。廢牌指此牌型此符合度的組合下，沒用到的牌；缺牌指此牌型此符合度的組合下，能增加符合度的牌。
// 	*/
//	public static int[] checkType( int player, int info_x[][], int[] source_x, int chiPeng, int target, boolean IsHu )//萬0-8,  筒10-18,  條20-28 ,  東南西北中發白30-36
//	{
//	    int[][] info = new int[4][11];
//		    for( int j=0; j<info_x.length; j++ )
//				{
//					System.arraycopy(info_x[j], 0, info[j], 0, info_x[j].length);
//				}
//					
//	    int[] source = new int[14];
//	    System.arraycopy(source_x, 0, source, 0, source_x.length);
//		int last = source[13];
//	    liPai( source, chiPeng, source.length-1 );
//		
//	    int[] num = {
//		              0,
//		             -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					 -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					};//0：符合數、1-14：廢牌、15-28：缺的牌
//		int x = 1;//廢牌陣列位置指針起始
//		int y = 15;//缺牌陣列位置指針起始
//		
//		try{
//	    switch( target )
//            {
//				case DaSiXi://0.大四喜：前置37.三風刻可胡，成立為1，不成立為0。
//				{
//				    int feng = 0;
//				    for( int i=0; i<=9; i+=3 )
//					    {
//						    if( source[i] == source[i+2] && source[i] >= 30 && source[i] <= 33 )//風刻
//							    {
//								    feng++;
//								}
//						}
//					if( feng==4 )
//					    {
//						    num[0] = 1;
//						}
//					break;
//				}
//				
//				case DaSanYuan://1.大三元：前置53.雙箭刻可胡，成立為1，不成立為0。排除7對
//				{
//				    int dsy = 0;
//				    for( int i=0; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]>=34 && hu[i*3]<=36 && hu[i*3]==hu[i*3+2] )//中發白刻子
//							    {
//								    dsy++;
//								}
//						}
//					if( dsy==3 )
//					    {
//						    num[0] = 1;
//						}
//					break;
//				}
//				
//				case LuYiShai://2.綠一色：23468條或發字組成，無缺牌
//				{
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    int s = source[i];
//							if( s == -10 || s == -11 ) s = source[i+1];//槓牌標誌轉換
//						    if( s==21 || s==22 || s==23 || s==25 || s==27 || s==35 )
//							    {
//									num[0]++;
//								}
//								else
//								{
//								    num[x] = s;//計入廢牌
//									x++;
//								}
//							num[15]=21;
//							num[16]=22;
//							num[17]=23;
//							num[18]=25;
//							num[19]=27;
//							num[20]=35;
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("綠一色符合數:"+num[0]);
//					break;
//				}
//				
//				case JiuLianBaoDeng://3.九蓮寶燈：聽九洞才算，21.清一色成立才檢查
//				{
//				    if( chiPeng > 0 ) break;//不可吃碰
//					/*if( source[0]%10==0 && source[0]%10==0 && source[0]%10==0 //111
//					 && source[0]%10==1 && source[0]%10==2 && source[0]%10==3 //234
//					 && source[0]%10==4 && source[0]%10==5 && source[0]%10==6 //567
//					 && source[0]%10==7 && source[0]%10==8 && source[0]%10==8 && source[0]%10==8 )//8999
//					    {
//						    num[0] = 1;System.out.println("num[0]="+num[0]);
//						}
//						else
//						{
//						   for(int i=0; i<14; i++)
//						       System.out.println(word[source[i]]);
//						}*/
//					int suit = source[0]/10;
//					if( info[suit][1]>2 && info[suit][2]>0 && info[suit][3]>0 //19.至少3張, 2-8至少各1張，LGame 還要檢查：若是1.123.456.789.999 + 1 OR pai[13]=2-8  =>>不成立，因為不是聽9洞
//					 && info[suit][4]>0 && info[suit][5]>0 && info[suit][6]>0
//					 && info[suit][7]>0 && info[suit][8]>0 && info[suit][9]>2 )
//					    {
//						    num[0] = 1;
//						}
//				    /*int type = 0;//檢查目前<萬筒條>何者較多，//0-8 => 1-9萬筒條
//				    if( info[0][0] < info[1][0] ) type = 1;//萬筒何者多?
//					if( info[type][0] < info[2][0] ) type = 2;//<萬筒>較多者與<條>，何者多?
//					
//					if( info[type][0] > 0 ) // 此花色至少要有一張，計算多的廢牌及符合的數量
//					    {
//							if( info[type][1]==0 )
//								{
//								    num[y] = type*10 + (1-1);//沒有，計入缺牌
//									y++;
//								}
//							    else if( info[type][1]>0 && info[type][1]<4 ) 
//							    {
//							        num[0] = num[0] + info[type][1];//1有1-3張
//								}
//							    else if( info[type][1]==4 ) 
//								{
//								    num[0] = num[0] + 3;//1有4張
//									num[x] = type*10 + (1-1);//第四張計入廢牌
//									x++;
//								}
//								
//						    for( int i=2; i<9; i++ )//2-8只要一張
//							    {
//								    if( info[type][i]==0 )
//									    {
//										    num[y] = type*10 + (i-1);//沒有，計入缺牌
//									        y++;
//										}
//								        else if( info[type][i]==1 ) 
//									    {
//										    num[0]++;//符合數加1
//										}
//									    else if( info[type][i]>1 )//2.3.4張
//									    {
//										    num[0]++;
//										    for( int j=2; j<=info[type][i]; j++ )
//											    {
//												    num[x] = type*10 + (i-1);//第2張以上計入廢牌
//									                x++;
//												}
//										}
//								}
//							
//							if( info[type][9]==0 )
//								{
//								    num[y] = type*10 + (9-1);//沒有，計入缺牌
//									y++;
//								}	
//								else if( info[type][9]>0 && info[type][9]<4 ) 
//							    {
//								    num[0] = num[0] + info[type][9];//9有1-3張
//								}
//								else if( info[type][9]==4 )
//								{
//								    num[0] = num[0] + 3;//9有4張
//									num[x] = type*10 + (9-1);//第四張計入廢牌
//									x++;
//								}
//						}
//					
//					for( int i=0; i<14; i++ )//找目標花色以外的廢牌
//					    {
//						    if( source[i] != 99 && source[i] / 10 != type )//不是目標花色、不是空牌，直接當廢牌
//							    {
//								    num[x] = source[i];//計入廢牌
//									x++;
//								}
//						}
//					if( last/10==type && ( last%10==0 || last%10==8 ) ) num[0]++;//最後一張是1或9
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("九蓮寶燈符合數"+num[0]);*/
//			        break;
//				}
//				
//				case SiGang://4.四槓：前置17.三槓，成立為1，不成立為0。
//				{
//				    if( chiPeng==0 ) 
//					    {
//						    break;
//						}
//					    else
//						{
//				            for( int i=0; i<chiPeng/3; i++ )
//					            {
//						            if( source[i*3+1]==-10 || source[i*3+1]==-11 )//明暗槓
//									    {
//										    num[0]++;
//										}
//						        }
//						}
//					if( num[0] > 3 ) num[0] = 1;
//					    else num[0] = 0;
//					break;
//				}
//				
//				case LianQiDui://5.連七對：成立為1，不成立為0，18.七對檢查完，看是否為連續
//				{
//				    //num[0] = 1;
//					liPai( source, 0, 13);
//				    if( source[12]==source[10]+1 && 
//					    source[10]==source[8]+1 && 
//						source[8]==source[6]+1 && 
//						source[6]==source[4]+1 && 
//						source[4]==source[2]+1 && 
//						source[2]==source[0]+1 )
//					    {
//							num[0] = 1;
//						}
//					break;
//				}
//				
//                case ShiSanYao://6.十三么：聽十三洞才算
//				{
//				    if( chiPeng > 0 ) break;//不可吃碰
//					for( int i=0; i<3; i++ )//檢查萬筒條
//					    {
//						    int xuShuo = 1;
//						    for( int j=0; j<2; j++ )//檢查序號一九
//							    {
//								    if( j==0 ) xuShuo = 1;
//									else xuShuo = 9;
//									
//						            if( info[i][xuShuo] == 0 )
//							            {
//								            num[y] = i*10 + (xuShuo-1);//沒有，計入缺牌
//									        y++;
//								        }
//								        else if( info[i][xuShuo] == 1 )
//								        {
//								            num[0]++;//符合數加1
//								        }
//								        else if( info[i][xuShuo] > 1 )
//								        {
//								            num[0]++;
//									        for( int k=2; k<=info[i][xuShuo]; k++ )
//									            {
//										            num[x] = i*10 + (xuShuo-1);//第2張以上計入廢牌
//									                x++;
//										        }
//								        }
//								}
//							for( int j=2; j<=8; j++ )//檢查序號2-8
//							    {
//								    if( info[i][j] > 0 )
//									    {
//										    num[x] = i*10 + (j-1);//計入廢牌
//									        x++;
//										}
//								}
//						}
//						
//					for( int i=1; i<=7; i++ )//檢查字30-36
//					    {
//						    if( info[3][i] == 0 )
//							    {
//								    num[y] = 3*10 + (i-1);//沒有，計入缺牌
//									y++;
//								}
//								else if( info[3][i] == 1 )
//								{
//								    num[0]++;//符合數加1
//								}
//								else if( info[3][i] > 1 )
//								{
//								    num[0]++;
//									for( int k=2; k<=info[3][i]; k++ )
//									    {
//									        num[x] = 3*10 + (i-1);//第2張以上計入廢牌
//									        x++;
//									    }
//								}
//						}
//					if( num[0]==13 )//13張具齊時
//					    {
//						    if( last/10<3 && (last%10==0||last%10==8) )//萬筒條之19
//							    {
//								    num[0]++;
//								}
//								else if( last/10==3 && last%10<=6 )//字
//								{
//								    num[0]++;
//								}
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("十三么符合數:"+num[0]);
//			        break;
//				}
//				
//				case QingYaoJiu://7.清么九：15.混么九成立後，檢查是否有字，成立為1，不成立為0。
//				{
//				    int qyj = 1;
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] >= 30 ) 
//							    {
//								    qyj = 0;
//									break;
//								}
//						}
//						
//					num[0] = qyj;
//					break;
//				}
//				
//				case XiaoSiXi://8.小四喜：前置37.三風刻可胡，成立為1，不成立為0。
//				{
//				    /*if( hu[12]>= 30 && hu[12] <= 33 )
//					    {
//						    num[0] = 1;
//						}*/
//					int feng = 0;
//				    for( int i=0; i<=9; i+=3 )
//					    {
//						    if( hu[i] == hu[i+2] && hu[i] >= 30 && hu[i] <= 33 )//風刻
//							    {
//								    feng++;
//								}
//						}
//					if( feng==3 && hu[12]>= 30 && hu[12] <= 33 )
//					    {
//						    num[0] = 1;
//						}
//					break;
//				}
//				
//				case XiaoSanYuan://9.小三元：前置53.雙箭刻可胡，成立為1，不成立為0。排除7對
//				{
//				    /*if( hu[12]>= 34 && hu[12] <= 36 )
//					    {
//						    num[0] = 1;
//						}*/
//					int dsy = 0;
//				    for( int i=0; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]>=34 && hu[i*3]<=36 && hu[i*3]==hu[i*3+2] )//中發白刻子
//							    {
//								    dsy++;
//								}
//						}
//					if( dsy==2 && hu[12]>= 34 && hu[12] <= 36 )
//					    {
//						    num[0] = 1;
//						}
//					break;
//				}
//				
//				case ZiYiShai://10.字一色，回傳值0-14
//				{
//				    int zi = 0;
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] == -10 || source[i] == -11 )//槓
//							    {
//								    source[i] = source[i+1];//槓牌中間的牌轉換標誌
//								}
//						    if( source[i]/10==3 )
//							    {
//								    zi++;
//								}
//								else
//								{
//						    	    num[x] = source[i];//計入廢牌
//						       	    x++;
//								}
//						}
//						
//					for( int i=30; i<=36; i++ )
//					    {
//						    num[y] = i;//計入缺牌
//						    y++;
//						}
//						
//					num[0] = zi;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("字一色符合數:"+num[0]);
//					break;
//				}
//				
//				case SiAnKe://11.四暗刻，成立為1，不成立為0。
//				{
//				    int sak = 0;
//					int sak2 = 0;
//					int sak3 = 0;
//				    if( chiPeng > 0 )//檢查暗槓
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3+1] == -11 )//是暗槓
//								    {
//									    sak++;
//									}
//						    }
//						}
//					
//					for( int i=chiPeng/3; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]==hu[i*3+2] ) sak2++;
//						}
//					
//					for( int i=0; i<=3; i++ )//四花色
//					    {
//						    for( int j=1; j<=9; j++ )
//							    if( info[i][j]>=3 )//111222333=>123123123，所以要檢查手牌
//							        {
//								        sak3++;
//								    }
//						}
//					if( sak2 > sak3 ) sak = sak + sak2;
//					    else sak = sak + sak3;
//					if( sak >= 4 ) num[0] = 1;
//						
//					break;
//				}
//				
//				case YiShaiShuangLongHui://12.一色雙龍會，回傳值0-14
//				{
//				    int chiCate = -1;//已吃的花色
//					int[] shun = {0,0};//123.789已吃的數量
//				    boolean fail = false;
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<chiPeng/3; i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    fail = true;
//										break;
//									}
//									else//有吃，若無序數46，且為同一色，把資料塞回關聯表
//								    {
//									    for( int j=0; j<3; j++ )//檢查吃組有無序數46，有則中斷
//										    {
//										        if( source[i*3+j]%10==3 || source[i*3+j]%10==5 )
//												    {
//													    fail = true;
//														break;
//													}
//											}
//											
//										if( !fail )//第二組以上的吃組，檢查與前面吃組是否為同花色，不是則中斷 => 吃2組不同則花色無法成立
//										    {
//											    if( i==0 ) chiCate = source[i*3]/10;//若只吃ㄧ組，則只檢查此花色
//												else if( i>0 )//有2組吃，於下方檢查花色是否相同
//												if( source[i*3]/10 != source[i*3-3]/10 )//花色不同
//												    {
//													    fail = true;
//														break;
//													}
//													else//花色相同
//													{
//													    chiCate = source[i*3]/10;//紀錄已吃的是哪種花色
//													}
//											}
//											
//										if( fail ) 
//										    {
//											    break;
//											}
//									}
//						    }
//							if( fail ) break;
//							//至此皆為同花色的吃且為123、789，紀錄順的頭
//							for( int i=0; i<chiPeng/3; i++ )
//					            {
//								    int head = source[i*3];
//									if( source[i*3] > source[i*3+1] ) head = source[i*3+1];
//									if( head > source[i*3+2] ) head = source[i*3+2];
//									if( head%10==0 ) shun[0]++;
//									else if( head%10==6 ) shun[1]++;
//							    }
//						}
//						
//					if( fail ) break;
//					
//					if( chiCate == -1 )//無已吃的花色，找1235789最多的花色
//						{
//						    int mx = 0;
//							int tar = 0;
//							for( int m=0; m<=2; m++ )
//							    {
//								    int mx_tmp = info[m][0] - info[m][4] - info[m][6];
//									if( mx_tmp > mx ) 
//									    {
//										    tar = m;
//											mx = mx_tmp;
//										}
//								}
//							chiCate = tar;
//						}
//						
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(">>>>>>>>>>"+Fan[12]+"目標花色:"+chiCate);
//					
//								
//						    int[] temp = {
//                      					   0,
//		                                  -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//							  		     };
//							int temp_x = 1;
//							int temp_y = 15;
//							//5的數量
//							if( info[chiCate][5] < 2 )//缺5
//							    {
//								    num[0] = num[0] + info[chiCate][5];
//									for( int j=2; j>2-info[chiCate][5]; j-- )
//									    {
//								    	    temp[temp_y] = chiCate*10+4;
//										    temp_y++;
//										}
//								}
//								else if( info[chiCate][5] == 2 )
//								{
//									num[0] = num[0] + 2;
//								}
//								else if( info[chiCate][5] > 2 )//多5
//								{
//									num[0] = num[0] + 2;
//									for( int j=0; j<info[chiCate][5]-2; j++ )
//									    {
//								    	    temp[temp_x] = chiCate*10+4;
//										    temp_x++;
//										}
//								}
//							
//						    if( shun[0]<2 )//123最多2組，未滿2組則找剩下的
//							    {
//								    if( shun[0]==0 )
//									    {
//										    if( info[chiCate][1]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][1];
//											if( info[chiCate][2]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][2];
//											if( info[chiCate][3]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][3];
//											
//										}
//										else if( shun[0]==1 )
//										{
//										    if( info[chiCate][1]>0 ) num[0] = num[0] + 1;
//											if( info[chiCate][2]>0 ) num[0] = num[0] + 1;
//											if( info[chiCate][3]>0 ) num[0] = num[0] + 1;
//										}
//										    
//								}
//								
//						    if( shun[1]<2 )//789最多2組，未滿2組則找剩下的
//							    {
//								    if( shun[1]==0 )
//									    {
//										    if( info[chiCate][7]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][7];
//											if( info[chiCate][8]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][8];
//											if( info[chiCate][9]>=2 ) num[0] = num[0] + 2; else num[0] = num[0] + info[chiCate][9];
//										}
//										else if( shun[1]==1 )
//										{
//										    if( info[chiCate][7]>0 ) num[0] = num[0] + 1;
//											if( info[chiCate][8]>0 ) num[0] = num[0] + 1;
//											if( info[chiCate][9]>0 ) num[0] = num[0] + 1;
//										}
//										    
//								}
//								
//							num[0] = num[0] + shun[0]*3 +shun[1]*3;
//							
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[12]+"符合數:"+num[0]);
//					break;
//				}
//				
//				case YiShaiSiTongShun://13.一色四同順，22一色三同順成立之後才檢查
//				{
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰
//								    {
//									    break;
//									}
//									else//有吃，把資料塞回關聯表
//								    {
//									    for( int j=0; j<3; j++ )
//										    {
//											    int a = source[i*3+j]/10;
//												int b = source[i*3+j]%10+1;
//												info[a][b] = info[a][b] + 1;
//											}
//									}
//						    }
//						}
//				    for( int i=0; i<=2; i++ )//萬筒條
//					    {
//						    for( int j=1; j<=6; j++ )//1234 ~ 6789
//							    {
//								    if( info[i][j]==4 && info[i][j+1]==4 && info[i][j+2]==4 )
//									    {
//										    num[0] = 1;
//										}
//								}
//						}
//						
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("一色四同順："+IsExist(num[0]) );
//					
//					break;
//				}
//				
//				case YiShaiSiJieGao://14.一色四節高，23一色三節高成立之後才檢查
//				{
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃
//								    {
//									    break;
//									}
//									else//有碰，把資料塞回關聯表
//								    {
//										int a = source[i*3]/10;
//										int b = source[i*3]%10+1;
//										info[a][b] = info[a][b] + 3;//槓也算3張
//									}
//						    }
//						}
//				    for( int i=0; i<=2; i++ )//萬筒條
//					    {
//						    for( int j=1; j<=6; j++ )//1234 ~ 6789
//							    {
//								    if( info[i][j]>2 && info[i][j+1]>2 && info[i][j+2]>2 && info[i][j+3]>2 )
//									    {
//										    num[0] = 1;
//										}
//								}
//						}
//						
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("一色四節高："+IsExist(num[0]) );
//					
//					break;
//				}
//				
//				case HunYaoJiu://15.混么九，1+9+字的刻子，未成刻子則要2張才算入符合數
//				{
//				    boolean IsYaoJiuExist = false;
//					if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃
//								    {
//									    break;
//									}
//									else//有明刻
//									{
//									    if( source[i*3]%10 != 0 && source[i*3]%10 != 8 && source[i*3]/10 < 3 )//不是1.9.字
//										    {
//											    break;
//											}
//											else//是1.9.字
//											{
//											    num[0] = num[0] + 3;
//											}
//									}
//						    }
//						}
//					
//					for( int i=0; i<=2; i++ )//序數刻
//					    {
//						    if( info[i][1] > 0 )
//							    {
//								    IsYaoJiuExist = true;
//									num[0] = num[0] + info[i][1];
//									if( info[i][1]==4 )  num[0]--;//4張只能算3張，所以扣一張
//								}
//						    if( info[i][9] > 0 )
//							    {
//								    IsYaoJiuExist = true;
//								    num[0] = num[0] + info[i][9];
//									if( info[i][9]==4 )  num[0]--;
//								}
//						}
//					
//					for( int i=1; i<=7; i++ )//字刻
//					    {
//						    if( info[3][i] == 2 )
//							    {
//								    num[0] = num[0] + 2;
//								}
//								else if( info[3][i] > 2 )
//								    {
//									    num[0] = num[0] + 3;
//									}
//						}
//						
//					if( !IsYaoJiuExist )//沒有序數1.9不成立
//					    {
//						    num[0] = 0;
//						}
//					for( int i=0; i<source.length; i++ )//廢牌
//					    {
//						    if( source[i]/10 < 3 && source[i]%10 != 0 && source[i]%10 != 8 )//萬筒條非19
//							    {
//								    num[x] = source[i];
//									x++;
//								}
//						}
//					
//					num[y] = 0; y++;
//					num[y] = 8; y++;
//					num[y] = 10; y++;
//					num[y] = 18; y++;
//					num[y] = 20; y++;
//					num[y] = 28; y++;
//					for( int i=30; i<=36; i++ )//計入缺牌
//					    {
//						    num[y] = i;
//						    y++;
//						}
//					break;
//				}
//				
//				case YiShaiSiBuGao://16.一色四步高
//				{
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    break;
//									}
//									else//有吃，把資料塞回關聯表
//								    {
//										for( int j=0; j<3; j++ )
//										    {
//											    int a = source[i*3+j]/10;
//												int b = source[i*3+j]%10+1;
//												info[a][b] = info[a][b] + 1;
//											}
//									}
//						    }
//						}
//					for( int i=0; i<=2; i++ )
//					    for( int j=1; j<=4; j++ )//123 + 234 + 345 + 456...
//					        {
//						        if( info[i][j]==1 && info[i][j+1]==2 && info[i][j+2]==3 && info[i][j+3]==3 && info[i][j+4]==2 && info[i][j+5]==1 )
//								    num[0] = 1;
//						    }
//					for( int i=0; i<=2; i++ )//123 + 345 + 567 + 789
//					    if( info[i][1]==1 && info[i][2]==1 && info[i][3]==2 && info[i][4]==1 && info[i][5]==2 && 
//						    info[i][6]==1 && info[i][7]==2 && info[i][8]==1 && info[i][9]==1 )
//								    num[0] = 1;
//									
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("一色四步高："+IsExist(num[0]) );
//					
//					break;
//				}
//				
//				case SanGang://17.三槓：前置66.暗槓、73.明槓，成立為1，不成立為0。
//				{
//				    if( chiPeng==0 ) 
//					    {
//						    break;
//						}
//					    else
//						{
//				            for( int i=0; i<chiPeng/3; i++ )
//					            {
//						            if( source[i*3+1]==-10 || source[i*3+1]==-11 )//明暗槓
//									    {
//										    num[0]++;
//										}
//						        }
//						}
//					if( num[0] > 2 ) num[0] = 1;
//					    else num[0] = 0;
//					break;
//				}
//				
//				case QiDui://18.七對：不可吃碰，手牌4張一樣當做2對，個數為單數的都是缺牌(不計入符合數)
//				{
//				    if( chiPeng > 0 ) break;
//					int dui = 0;//對
//					for( int i=0; i<4; i++ )//萬筒條字
//					    {
//						    for( int j=1; j<info[i].length; j++ )
//							    {
//									//if( info[i][j] == 1 ) 
//									    //{
//										    //num[y] = i*10 + j -1;//缺牌
//											//if(y==28)System.out.println("!!!!!!!");
//											//y++;
//										//}
//										//else 
//										if( info[i][j] == 2 ) 
//									    {
//										    dui++;
//										}
//									    else if( info[i][j] == 3 ) 
//									    {
//										    dui++;
//											//num[y] = i*10 + j -1;//缺牌
//											//if(y==28)System.out.println("!!!!!!!");
//											//y++;
//										}
//									    else if( info[i][j] == 4 ) 
//									    {
//										    dui = dui + 2;
//										}
//								}
//						}
//					num[0] = dui*2;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("七對符合數:"+num[0]);
//				    break;
//				}
//				
//				case QiXingBuKao://19.七星不靠，33.全不靠成立後，看字牌是否齊全，成立為1，不成立為0。
//				{
//				    int count = 0;
//						    for( int j=1; j<=7; j++ )//東到白
//							    {
//									if( info[3][j] > 0 )//有該字牌
//										{
//											 count++;
//										}
//								}
//					if( count==7 )
//					    {
//						    num[0] = 1;
//						}
//					break;
//				}
//				
//				case QuanShuangKe://20.全雙刻：前置47.碰碰和，成立為1，不成立為0。
//				{
//				    num[0] = 1;
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] >=30 || source[i]%2==0 )//字或單數刻
//							    {
//								    num[0] = 0;
//									break;
//								}
//						}
//					break;
//				}
//				
//				case QingYiShai://21.清一色，回傳值0-14
//				{
//					int CPCate = -1;
//					boolean fail = false;
//					if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<chiPeng/3; i++ )
//							    {
//								    if( i==0 && source[i*3] < 30 ) CPCate = source[i*3]/10;//若只吃碰一組，非字，以此花色為準
//									else if( i > 0 && ( source[i*3]/10 != CPCate ) )//若吃碰2組，花色不相同
//									    {
//										    fail = true;//不成立
//										}
//								}
//						}
//						
//					if( fail ) break;
//					
//					int[] qing = { 0, 0, 0 };//萬筒條的數量
//				    for( int i=0; i<14; i++ )
//					    {
//						    if( source[i] == -10 || source[i] == -11 )//槓
//							    {
//								    source[i] = source[i+1];//槓牌中間的牌轉換標誌
//								}
//							int cate = source[i]/10;
//							
//						    if( cate <= 2 ) qing[cate]++;
//						}
//						
//					int max = 0;
//					if( CPCate == -1 )//花色未確定
//					    {
//							max = qing[0];
//							if( qing[0] < qing[1] ) { max = qing[1]; CPCate = 1; }
//							if( max < qing[2] ) { max = qing[2]; CPCate = 2; }
//						}
//						else//花色已確定
//						{
//						    max = qing[CPCate];
//						}
//					
//					for( int i=0; i<=8; i++ )//CPCate的序號1-9缺牌
//					    {
//						    if( i<=6 )
//							num[y] = CPCate*10 + i;
//							y++;
//						}
//						
//					for( int i=0; i<source.length; i++ )//不同花色為廢牌
//					    {
//						    if( source[i]/10 != CPCate )
//							    {
//								    num[x] = source[i];
//									x++;
//								}
//						}
//						
//					num[0] = max;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("清一色符合數:"+num[0]);
//					break;
//				}
//				
//				case YiShaiSanTongShun://22一色三同順
//				{
//				    if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰
//								    {
//									    peng++;
//									}
//									else//有吃，把資料塞回關聯表
//								    {
//									    for( int j=0; j<3; j++ )
//										    {
//											    int a = source[i*3+j]/10;
//												int b = source[i*3+j]%10+1;
//												info[a][b] = info[a][b] + 1;
//											}
//									}
//						    }
//							if( peng >= 2 )//2組碰，一色三同順無法成立
//							{
//							    break;
//							}
//						}
//					
//					int sum = 0;
//				    for(int i=0; i<=2; i++)//萬筒條
//					    {
//						    for(int j=1; j<=7; j++)//123.234.345......789
//							{
//							    sum = info[i][j] + info[i][j+1] + info[i][j+2];
//								if( sum > num[0] )
//								    {
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("一色三同順符合數:"+num[0]);
//					break;
//				}
//				
//				case YiShaiSanJieGao://23.一色三節高，無缺廢牌，返回0-9
//                {
//				    if( chiPeng > 0 )
//					    {
//						    int chi = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃
//								    {
//									    chi++;
//									}
//									else//有碰，把資料塞回關聯表
//								    {
//										int a = source[i*3]/10;
//										int b = source[i*3]%10+1;
//										info[a][b] = info[a][b] + 3;//槓也算3張
//									}
//						    }
//							if( chi >= 2 )//2組吃，一色三節高無法成立
//							{
//							    break;
//							}
//						}
//						
//				    int sum = 0;
//				    for(int i=0; i<=2; i++)//萬筒條
//					    {
//						    for(int j=1; j<=7; j++)//123.234.345......789
//							{
//							    int a = info[i][j]   > 1 ? info[i][j]   : 0;//單張不計
//							    int b = info[i][j+1] > 1 ? info[i][j+1] : 0;
//							    int c = info[i][j+2] > 1 ? info[i][j+2] : 0;
//							    sum = a + b + c;
//								if( sum > num[0] )
//								    {
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("一色三節高符合數:"+num[0]);
//				    break;
//				}
//				
//				case QuanDai://24.全大，大於五成立後，檢查是否有序數6的牌，成立為1，不成立為0。
//				{
//				    num[0] = 1;
//				    for( int i=0; i<14; i++ )
//					    {
//						    if( source[i]%10 == 5 )
//							    {
//								    num[0] = 0;
//								    break;
//								}
//						}
//					break;
//				}
//				
//				case QuanZhong://25.全中，全帶五成立後，檢查是否有序數3.7的牌，成立為1，不成立為0。
//				{
//				    num[0] = 1;
//				    for( int i=0; i<14; i++ )
//					    {
//						    if( source[i]%10 == 2 || source[i]%10 == 6 )
//							    {
//								    num[0] = 0;
//								    break;
//								}
//						}
//					break;
//				}
//				
//				case QuanXiao://26.全小，小於五成立後，檢查是否有序數4的牌，成立為1，不成立為0。
//				{
//				    num[0] = 1;
//				    for( int i=0; i<14; i++ )
//					    {
//						    if( source[i]%10 == 3 )
//							    {
//								    num[0] = 0;
//								    break;
//								}
//						}
//					break;
//				}
//				
//				case QingLong://27.清龍：吃的順要123.456.789，手牌可任意組合
//				{
//				    boolean bl[][] = new boolean[3][9];
//					if( chiPeng > 0 )
//					    {
//						    int cp = chiPeng / 3;//吃碰組數，此處至少為1
//						    for( int i=0; i<cp; i++)
//							    {
//								    if( source[i*3] != source[i*3+2] )//吃碰組的頭不等於尾 => 吃
//									    {
//											int head = source[i*3];//找順頭
//											if( source[i*3] > source[i*3+1] )  head = source[i*3+1];
//											if( head > source[i*3+2] )  head = source[i*3+2];
//											if( head%10==0 )//1萬、1筒、1條
//											    {
//												    bl[head/10][0] = true;
//													bl[head/10][1] = true;
//													bl[head/10][2] = true;
//												}
//												else if( head%10==3 )//4萬、4筒、4條
//												{
//												    bl[head/10][3] = true;
//													bl[head/10][4] = true;
//													bl[head/10][5] = true;
//												}
//												else if( head%10==6 )//7萬、7筒、7條
//												{
//												    bl[head/10][6] = true;
//													bl[head/10][7] = true;
//													bl[head/10][8] = true;
//												}
//										}
//								}
//						}
//					for( int j=chiPeng; j<source.length; j++ )//計算手牌
//						{
//							if( source[j]/10 < 3 )
//							    {
//								    bl[source[j]/10][source[j]%10] = true;
//								}
//						}
//					int sum = 0;
//					for( int k=0; k<3; k++ )
//					    {
//						    for( int m=0; m<9; m++ )
//							    {
//								    if( bl[k][m] == true )
//									    sum++;
//								}
//							if( sum > num[0] )
//							    {
//								    num[0] = sum;
//								}
//							sum =0;
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("清龍符合數:"+num[0]);
//				    break;
//				}
//				
//				case SanShaiShuangLongHui://28.三色雙龍會：兩色的123+789+第三色的55
//				{
//				    boolean fail = false;
//					int[][] chiHead = new int[3][2];//萬筒條的123+789
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    fail = true;
//										break;
//									}
//									else//有吃，若無序數46，記錄順頭
//								    {
//									    for( int j=0; j<3; j++ )//檢查吃組有無序數46，有則中斷，無則塞入關聯表
//										    {
//										        if( source[i*3+j]%10==3 || source[i*3+j]%10==5 )
//												    {
//													    fail = true;
//														break;
//													}
//											}
//											
//										if( fail ) 
//										    {
//											    break;
//											}
//											else
//											{
//											    for( int j=0; j<4; j++ )//找出順頭並記錄
//												    {
//														int hd = source[i*3];
//														if( hd > source[i*3+1] ) hd=source[i*3+1];
//														if( hd > source[i*3+2] ) hd=source[i*3+2];
//														if( hd%10==0 ) chiHead[hd/10][0]++;
//														    else if( hd%10==6 ) chiHead[hd/10][1]++;
//													}
//											}
//									}
//						    }
//							if( fail ) break;
//						}
//					
//				    for( int i=0; i<=2; i++ )//55是萬筒條那一種
//					    {
//						    int[] temp = {
//                      					   0,
//		                                  -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//							  		     };
//							int temp_x = 1;
//							int temp_y = 15;
//							int sum = 0;
//							if( info[i][5] < 2 )//缺5
//							    {
//								    for( int j=2; j>2-info[i][5]; j-- )
//									    {
//								    	    temp[temp_y] = i*10+4;
//										    temp_y++;
//											sum = sum + 1;
//										}
//								}
//								else if( info[i][5] == 2 )
//								{
//									sum = sum + 2;
//								}
//								else if( info[i][5] > 2 )//多5
//								{
//									sum = sum + 2;
//									for( int j=0; j<info[i][5]-2; j++ )
//									    {
//								    	    temp[temp_x] = i*10+4;
//										    temp_x++;
//										}
//								}
//								
//							for( int j=1; j<=9; j++ )//123+789
//							    {
//								    for( int k=0; k<=2; k++ )//檢查剩下2種花色的123+789
//									    { 
//										    if( k==i ) continue;//跟55同花色的檢查跳過
//											if( chiHead[k][0]>0 )//此花色的123順已經吃了
//											    {
//												    if( j==1 || j==2 ) continue;//跳過
//													if( j==3 )
//													    {
//														    sum = sum + 3;
//															continue;//跳過
//														}
//												}
//											if( chiHead[k][1]>0 )//此花色的789順已經吃了
//											    {
//												    if( j==7 || j==8 ) continue;//跳過
//													if( j==9 )
//													    {
//														    sum = sum + 3;
//															continue;//跳過
//														}
//												}
//								    	    if( info[k][j] > 0 && ( j<=3 || j>=7 ) )//未吃過123+789，計算手牌存在數量
//											    {
//												    sum++;
//													if( info[k][j] > 1 )//多的全記廢牌
//													    {
//														    for( int p=0; p<info[k][j]-1; p++ )
//															    {
//																    temp[temp_x] = k*10 + j - 1;
//										    				        temp_x++;
//																}
//														}
//												}
//												else if( info[k][j] == 0 && ( j<=3 || j>=7 ) )//缺牌
//												{
//								    			    temp[temp_y] = k*10 + j - 1;
//												    temp_y++;
//												}
//												else if( info[k][j] > 0 && ( j>=4 || j<=6 ) )//廢牌
//												{
//												    temp[temp_x] = k*10 + j - 1;
//										    		temp_x++;
//												}
//										}
//								}
//								
//							if( sum > num[0] )
//							    {
//								    num[0] = sum;
//									for( int j=1; j<num.length; j++ )
//									    {
//										    num[j] = temp[j];
//										}
//								}
//						}
//					break;
//				}
//				
//				case YiShaiSanBuGao://29.一色三步高：49.三色三步高的單色版，返回0-9，有記缺牌
//				{
//				    int[][] shun = new int[3][7];//萬筒條字7種順的數量
//				    if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    peng++;
//									}
//									else//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//							if( peng >= 2 )//2組碰，三步高無法成立
//							{
//							    break;
//							}
//						}
//					
//					int sum = 0;
//				    for(int i=0; i<3; i++)//萬筒條
//					    {
//						    for(int j=1; j<=5; j++)//順頭 123.234.345.456.567
//							{
//							    int[] temp = {
//                      						   0,
//		                                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                          -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//											  };
//								int temp_x = 1;
//								int temp_y = 15;
//								int[][] infoTmp = new int[4][11];
//		                            for( int jj=0; jj<info.length; jj++ )
//				                        {
//					                        System.arraycopy(info[jj], 0, infoTmp[jj], 0, info[jj].length);
//				                        }
//								
//							    for( int s=0; s<3; s++ )
//								    {
//									    for( int t=0; t<3; t++ )// 順序=> 123 + 234 + 345
//										    {
//											    if( shun[i][j+s-1] > 0 )//此順已有吃了
//												    {
//													    sum = sum + 3;
//														break;
//													}
//											    int w = ( infoTmp[i][0+j+s+t] > 0 ) ? 1 : 0;
//												sum = sum + w;
//												if( w==1 )
//												    {
//													    infoTmp[i][0+j+s+t]--;
//													}
//													else if( w==0 )
//												    {
//													    temp[temp_y] = s*10 + j + s + t -1;//記入缺牌
//														temp_y++;
//													}
//											}
//									}
//								if( sum > num[0] )
//								    {
//									    num = temp;
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//							
//							for(int j=1; j<=3; j++ )//順頭 135.246.357
//							{
//							    int[] temp = {
//                      						   0,
//		                                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                          -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//											  };
//								int temp_x = 1;
//								int temp_y = 15;
//								int[][] infoTmp = new int[4][11];
//		                            for( int jj=0; jj<info.length; jj++ )
//				                        {
//					                        System.arraycopy(info[jj], 0, infoTmp[jj], 0, info[jj].length);
//				                        }
//										
//							    for( int s=0; s<3; s++ )
//								    {
//									    for( int t=0; t<3; t++ )//  idx[0]	的順序：萬筒條 => 123萬+345筒+567條
//										    {
//											    if( shun[i][j+s*2-1] > 0 )//此順已有吃了
//												    {
//													    sum = sum + 3;
//														break;
//													}
//											    int w = ( infoTmp[i][0+j+s*2+t] > 0 ) ? 1 : 0;
//												sum = sum + w;
//												if( w==1 )
//												    {
//													    infoTmp[i][0+j+s*2+t]--;
//													}
//													else if( w==0 )
//												    {
//													    temp[temp_y] = s*10 + j + s + t -1;//記入缺牌
//														temp_y++;
//													}
//											}
//									}
//								if( sum > num[0] )
//								    {
//									    num = temp;
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[29]+"符合數:"+num[0]);
//					break;
//				}
//				
//				/*case QuanDaiWu://30.全帶五：禁碰字、禁碰非五、禁吃含1289>>>>>>>>>>>>可以胡牌了再檢查，AI難做= =
//				{
//					int[] head = { -1, -1, -1, -1 };//最多四組吃的頭為何?，345萬記3萬、567筒記5筒
//					int[] shun = { 0, 0, 0};//萬筒條的順
//					boolean pengWan = false;//碰種類為何?萬筒條?
//					boolean pengTong = false;
//					boolean pengTiao = false;
//					
//				    if( chiPeng > 0 )
//					    {
//						    boolean fail = false;
//							
//				            for( int i=0; i<chiPeng/3; i++ )
//					    	    {
//						    	    int qdw = source[i] % 10;
//						    	    if( source[i*3] >= 30 ) fail = true;//禁碰字
//								    if( (source[i*3] == source[i*3+2]) && qdw != 4 ) fail = true;//禁碰非五
//							    }
//							if( !fail )
//							    {
//									for( int i=0; i<chiPeng; i++ )
//					    	    	    {
//						    	 	        int qdw = source[i] % 10;
//									    	if( qdw == 0 || qdw == 1 || qdw == 7 || qdw == 9 ) //禁吃含1289
//											    {
//												    fail = true;
//													break;
//												}
//							    	    }
//								}
//							
//							if( fail ) break;
//							
//							if( !fail ) //執行至此，吃碰都是有5，檢查已吃碰的555刻.345.456.567順，減少下方檢查範圍
//							    {
//								    num[0] = num[0] + chiPeng;
//									for( int p=chiPeng; p<source.length; p++ )
//													    {
//														    if( source[p]<30 && source[p]%10>1 && source[p]%10<7 )
//															    {
//																    num[0]++;
//																}
//																else
//																{
//																    num[x] = source[p];//記入廢牌
//														            x++;
//																}
//														}
//								    for( int i=0; i<chiPeng/3; i++ )
//					    	    	    {
//								    	    if( source[i] == source[i+2] )//碰555
//											    {
//												    int peng = source[i] / 10;
//												    switch( peng )
//													    {
//														    case 0:{
//															    pengWan = true;
//															    break;}
//																
//														    case 1:{
//															    pengTong = true;
//															    break;}
//																
//														    case 2:{
//															    pengTiao = true;
//															    break;}
//																
//															default:{
//															    System.out.println("全帶五已碰牌檢查錯誤：peng = "+peng);
//															    break;}
//														}
//												}
//												else//此組為吃，找出頭張
//												{
//												    int tou = source[i];
//													if( source[i] > source[i+1] ) tou = source[i+1];
//													if( tou > source[i+2] ) tou = source[i+2];
//													head[i] = tou;
//													shun[source[i]/10]++;//該種類的順加1
//												}
//							    	    }
//								//}
//								
//						//}
//					
//				    int[][] idx = {
//					                {0,1,2,},//萬筒條
//					                {0,2,1,},//萬條筒
//					                {1,0,2,},//筒萬條
//					                {1,2,0,},//筒條萬
//					                {2,0,1,},//條萬筒
//					                {2,1,0,},//條筒萬
//					              };
//				    int[][] combo = 
//					    {
//						    {0,0,0,3,1,1},//A      //花色A序數5的刻數 + 花色A序數5的順數 + 花色B序數5的刻數 +花色B序數5的順數 + 花色C序數5的將眼 + 花色C序數5的順數。程式算出來的。
//                            {0,0,0,4,1,0},//B
//                            {0,1,0,2,1,1},//C
//                            {0,1,0,3,1,0},//D
//                            {0,1,1,1,1,1},//E
//                            //{0,2,0,1,1,1},//C
//                            {0,2,0,2,1,0},
//                            {0,2,1,0,1,1},//F
//                            {0,2,1,1,1,0},//G
//                            //{0,3,0,0,1,1},//A
//                            //{0,3,0,1,1,0},//D
//                            {0,3,1,0,1,0},//H
//                            //{0,4,0,0,1,0},//B
//                            //{1,0,0,2,1,1},//F
//                            //{1,0,0,3,1,0},//H
//                            {1,0,1,1,1,1},//I
//                            //{1,1,0,1,1,1},//E
//                            //{1,1,0,2,1,0},//G
//                            //{1,1,1,0,1,1},//I
//                            {1,1,1,1,1,0}
//						};
//						
//					//int max = 0;//最大符合數
//					//int maxFei[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//廢牌
//					//int maxQue[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//缺牌
//					//int temp = 0;//暫存的符合數
//					//int temp2 = 0;//暫存的符合數2
//					for( int i=0; i<combo.length; i++ )//檢查何種<<全帶五組合>>
//					    {
//						    for( int j=0; j<idx.length; j++ )//使用何組cate( 萬筒條順序 )
//							    {
//								    boolean stop = false;
//								    int[] cate = idx[j];
//									for( int k=0; k<cate.length; k++ )//依cate的花色序檢查combo[i] 的  0.1 + 2.3 + 4
//									    {
//										    //for( int m=0; m<combo[i].length; m++ )//依序檢查combo 第二維的標準
//											    //{
//												    //已吃碰數量若超出要求，則不用計算，若未超出，則加入符合數
//												    if( cate[k]==0 )//cate 順序檢查萬
//											    	    {
//												            if( pengWan )//已有碰萬刻子
//															    {
//																    if( k!=2 && combo[i][k*2]==0 )//k=2.k*2.是將眼  、  檢查萬刻子的數量要為0
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為碰萬刻子已不符此組合條件
//																		}
//																		else if( k!=2 && combo[i][k*2]==1 )
//																		    {
//																			    temp = temp + 3;
//																			}
//																}
//															if( shun[0] > 0 )//已吃ㄧ個萬順子以上
//															    {
//																    if( combo[i][k*2+1]<shun[0] )//萬順數量大於表定需要的
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為萬順子數量已超出此組合條件
//																		}
//																		else
//																		{
//																		    temp = temp + shun[0]*3;
//																		}
//																}
//													    }
//													    else if( cate[k]==1 )//cate 順序檢查筒
//											    	    {
//												            if( pengTong )//已有碰筒刻子
//															    {
//																    if( k!=2 && combo[i][k*2]==0 )//k=2.k*2.是將眼  、  檢查筒刻子的數量要為0
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為碰筒刻子已不符此組合條件
//																		}
//																		else if( k!=2 && combo[i][k*2]==1 )
//																		    {
//																			    temp = temp + 3;
//																			}
//																}
//															if( shun[1] > 0 )//已吃ㄧ個筒順子以上
//															    {
//																    if( combo[i][k*2+1]<shun[0] )//筒順數量大於表定需要的
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為筒順子數量已超出此組合條件
//																		}
//																		else
//																		{
//																		    temp = temp + shun[0]*3;
//																		}
//																}
//													    }	
//													    else if( cate[k]==2 )//cate 順序檢查條
//											    	    {
//												            if( pengTiao )//已有碰條刻子
//															    {
//																    if( k!=2 && combo[i][k*2]==0 )//k=2.k*2.是將眼  、  檢查條刻子的數量要為0
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為碰條刻子已不符此組合條件
//																		}
//																		else if( k!=2 && combo[i][k*2]==1 )
//																		    {
//																			    temp = temp + 3;
//																			}
//																}
//															if( shun[2] > 0 )//已吃ㄧ個條順子以上
//															    {
//																    if( combo[i][k*2+1]<shun[0] )//條順數量大於表定需要的
//																	    {
//																		    stop = true;
//																		    break;//此組花色順序不用檢查，因為條順子數量已超出此組合條件
//																		}
//																		else
//																		{
//																		    temp = temp + shun[0]*3;
//																		}
//																}
//													    }	
//										    	    
//													//進行至此，刻順都未超出表的要求，開始進行未吃碰部份的符合數計算
//													
//													//k = 0 ：檢查花色cate[0] 是否有 combo[i][0]*3 的數目
//												    //k = 0 ：檢查花色cate[0] 是否有 combo[i][1] 的帶5順數量，最高符合數為combo[i][1] *3，若無，最高符合數為何?
//										    	    //k = 1 ：檢查花色cate[1] 是否有 combo[i][2]*3 的數目
//												    //k = 1 ：檢查花色cate[1] 是否有 combo[i][3] 的帶5順數量，最高符合數為combo[i][3] *3，若無，最高符合數為何?
//												    //k = 2 ：檢查花色cate[2] 是否有 combo[i][4] 的帶5順數量，最高符合數為combo[i][4] *3，若無，最高符合數為何?
//										   	        //k = 2 ：檢查花色cate[2] 是否有 2張將眼
//													
//													//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<偷懶= =找不到適合的演算法，只好3-7的萬筒條都算是符合數>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//													
//												//}
//										    if( stop ) break;//下一個花色組合
//										}
//								}
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[30]+"符合數:"+num[0]);
//					break;
//				}*/
//				
//				case SanTongKe://31;三同刻：前置64.雙同刻
//				{
//				    int[][] stk = new int[3][9];
//					for(int i=0; i<hu.length/3; i++)
//					    {
//						    if( hu[i*3]<30 && hu[i*3]==hu[i*3+2] )
//							    {
//								    stk[hu[i*3]/10][hu[i*3]%10]++;//紀錄刻子數量與類別
//								}
//						}
//					
//					int sum = 0;
//					for(int j=0; j<=8; j++)//序數
//						{
//						    if( stk[0][j]==1 && stk[1][j]==1 && stk[2][j]==1 )//該序數於三花色各有一刻子
//							    num[0] = 1;
//						}
//					break;
//				}
//				
//				case SanAnKe://32.三暗刻，成立為1，不成立為0。
//				{
//				    int sak = 0;
//					int sak2 = 0;
//					int sak3 = 0;
//				    if( chiPeng > 0 )//檢查暗槓
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( hu[i*3+1] == -11 )//是暗槓
//								    {
//									    sak++;
//									}
//						    }
//						}
//					
//					for( int i=chiPeng/3; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]==hu[i*3+2] ) sak2++;
//						}
//					for( int i=0; i<=3; i++ )//四花色
//					    {
//						    for( int j=1; j<=9; j++ )
//							    if( info[i][j]>=3 )//111222333=>123123123，所以要檢查手牌
//							        {
//								        sak3++;
//								    }
//						}
//					if( sak2 > sak3 ) sak = sak + sak2;
//					    else sak = sak + sak3;
//					if( sak >= 3 ) num[0] = 1;
//						else num[0] = 0;
//					break;
//				}
//				
//				case QuanBuKao://33全不靠：34組合龍+7種字=只缺2，成立後檢查19.七星不靠是否成立
//				{
//				    if( chiPeng > 0 ) break;//有吃碰就無法成立
//					
//					int[][] idx = {//配合下方迴圈，檢查序號1-9即可得知147+258+369符合數
//					                {0,1,2,0,1,2,0,1,2,},//萬筒條
//					                {0,2,1,0,2,1,0,2,1,},//萬條筒
//					                {1,0,2,1,0,2,1,0,2,},//筒萬條
//					                {1,2,0,1,2,0,1,2,0,},//筒條萬
//					                {2,0,1,2,0,1,2,0,1,},//條萬筒
//					                {2,1,0,2,1,0,2,1,0,},//條筒萬
//					              };
//					
//					int max = 0;//147+258+369最大符合數
//					int maxFei[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//廢牌
//					int maxQue[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//缺牌
//					int temp = 0;//暫存的符合數
//					for( int i=0; i<6; i++ )//idx的6種花色組合
//					    {
//						    int[] fp = new int[14];
//							for( int r=0; r<14; r++) fp[r] = source[r];
//							int[] qp = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//暫存缺牌
//				            for( int j=1; j<=9; j++ )//序數1-9
//					            {
//						            int k = idx[i][j-1];//要檢查的花色
//								    if( info[k][j] > 0 )
//								        {//有
//									        temp++;
//											for( int m=0; m<fp.length; m++ )//自暫存陣列中移除已有的牌
//											    {
//												    if( fp[m] == k*10+j-1 )
//													    {
//														    fp[m] = -1;
//															break;
//														}
//												}
//									    }
//										else//沒有
//										{
//										    for( int m=0; m<qp.length; m++ )
//											    {
//												    if( qp[m] == -1 )
//													    {
//														    qp[m] = k*10+j-1;
//														}
//												}
//										}
//						        }
//								
//							if( temp > max ) //若此組合之符合數大於目前最大符合數，取代之
//							    {
//								    max = temp;
//									maxFei = fp;
//									maxQue = qp;
//								}
//							temp = 0;
//						}
//					
//					num[0] = max;
//					//處理缺廢陣列
//					for( int i=1; i<=28; i++ )
//					    {
//						    if( i<15 )
//							    {
//								    num[i] = maxFei[i-1];
//								}
//								else
//								{
//								    num[i] = maxQue[i-15];
//								}
//						}
//					//檢查七種字，都有就是七星
//					int count = 0;
//						    for( int j=1; j<=7; j++ )//東到白
//							    {
//											if( info[3][j] > 0 )//有該字牌
//											    {
//												    count++;
//													if( info[3][j] > 1 )//該字牌有2張以上
//												    for( int k=1; k<info[3][j]; k++ )//計入廢牌
//													    {
//														    for( int r=1; r<=14; r++ )
//															    {
//																    if( num[r] == -1 )
//																	    {
//																		    num[r] = 30 + j - 1;
//																			break;
//																		}
//																}
//														}
//												}
//								}
//						
//					num[0] = num[0] + count;
//					
//					/*System.out.println("全不靠廢牌=");
//					for( int i=1; i<15; i++ )
//					{
//					try{
//					if( num[i]!=-1 )
//					System.out.print(word[num[i]]+"  _");
//					}catch(Exception e){ System.out.println("EEXX= i =>"+i+"__num[i]="+num[i]); }
//					}*/
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[33]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				//此組合龍方法目前只適用在全不靠成立後的檢查，一般情況下要用LGame.TMDZuHeLong()
//				case ZuHeLong://34.組合龍147+258+369，廢牌、缺牌是針對147、258、369而言
//				{
//				    if( chiPeng > 3 ) break;//吃碰超過1組就無法成立
//					
//					int[][] idx = {//配合下方迴圈，檢查序號1-9即可得知符合數
//					                {0,1,2,0,1,2,0,1,2,},//萬筒條
//					                {0,2,1,0,2,1,0,2,1,},//萬條筒
//					                {1,0,2,1,0,2,1,0,2,},//筒萬條
//					                {1,2,0,1,2,0,1,2,0,},//筒條萬
//					                {2,0,1,2,0,1,2,0,1,},//條萬筒
//					                {2,1,0,2,1,0,2,1,0,},//條筒萬
//					              };
//								  
//					int max = 0;//最大符合數
//					int maxFei[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//廢牌
//					int maxQue[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//缺牌
//					int temp = 0;//暫存的符合數
//					for( int i=0; i<6; i++ )//idx的6種花色組合
//					    {
//						    int[] fp = new int[14];
//							for( int r=0; r<14; r++) fp[r] = source[r];
//							int[] qp = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,};//暫存缺牌
//				            for( int j=1; j<=9; j++ )//序數1-9
//					            {
//						            int k = idx[i][j-1];//要檢查的花色
//								    if( info[k][j] > 0 )
//								        {//有
//									        temp++;
//											for( int m=0; m<fp.length; m++ )//自暫存陣列中移除已有的牌
//											    {
//												    if( fp[m] == k*10+j-1 )
//													    {
//														    fp[m] = -1;
//															break;
//														}
//												}
//									    }
//										else//沒有
//										{
//										    for( int m=0; m<qp.length; m++ )
//											    {
//												    if( qp[m] == -1 )
//													    {
//														    qp[m] = k*10+j-1;
//														}
//												}
//										}
//						        }
//								
//							//int ck = checkLeftPai(fp);//剩餘牌中3+2組合的最大值
//							//System.out.println("ck="+ck);
//							//if( temp + ck > max ) //若此組合之符合數大於目前最大符合數，取代之
//							if( temp > max ) //若此組合之符合數大於目前最大符合數，取代之
//							    {
//								    //max = temp + ck;
//								    max = temp;
//									maxFei = fp;
//									maxQue = qp;
//								}
//							temp = 0;
//						}
//						
//					num[0] = max;
//					//處理缺廢陣列
//					for( int i=1; i<=28; i++ )
//					    {
//						    if( i<15 )
//							    {
//								    num[i] = maxFei[i-1];
//								}
//								else
//								{
//								    num[i] = maxQue[i-15];
//								}
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[34]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				case DaiYuWu://35.大於五：序數大於5的都是缺牌
//				{
//					boolean fail = false;
//				    if( chiPeng > 0 )//有吃碰 => 檢查明牌
//					    {
//						    for( int i=0; i<chiPeng; i++)
//							    {
//								    if( source[i]%10 < 5 || source[i]/10 == 3 )//吃碰序數12345或是字 => 不成立
//									    {
//										    fail = true;
//										    break;
//										}
//								}
//						}
//						
//					if( fail ) break;
//					num[0] = num[0] + chiPeng;//執行至此，表示指針之前都符合
//					
//					for( int i=0; i<4; i++ )//檢查手牌萬筒條字
//					    {
//						
//					    for( int j=1; j<=9; j++ )//各序號
//						    {
//							    if( i < 3 && j > 5 && info[i][j] > 0 )//萬筒條序號大於5
//								    {
//									    num[0] = num[0] + info[i][j];
//									}
//									else if( ((i<3 && j<=5)||(i==3)) && info[i][j] > 0 )//萬筒條序號小於等於5，或是字
//									{
//									    num[x] = i*10 + (j-1);//計入廢牌
//									    x++;
//									}
//							}
//						}
//							
//					for( int i=0; i<3; i++ )//萬筒條序數 > 5，都是缺牌
//					    for( int j=6; j<10; j++ )
//					        {
//						        num[y] = i*10 + (j-1);//缺一張，計入缺牌
//							    y++;
//						    }
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[35]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				case XiaoYuWu://36.小於五：序數小於5的都是缺牌
//				{
//					boolean fail = false;
//				    if( chiPeng > 0 )//有吃碰 => 檢查明牌
//					    {
//						    for( int i=0; i<chiPeng; i++)
//							    {
//								    if( source[i]%10 > 3 || source[i]/10 == 3 )//吃碰序數56789或是字 => 不成立
//									    {
//										    fail = true;
//										    break;
//										}
//								}
//						}
//						
//					if( fail ) break;
//					num[0] = num[0] + chiPeng;//執行至此，表示指針之前都符合
//						
//					for( int i=0; i<4; i++ )//檢查手牌萬筒條字
//					    for( int j=1; j<=9; j++ )//各序號
//						    {
//							    if( i < 3 && j < 5 && info[i][j] > 0 )//萬筒條序號小於5
//								    {
//									    num[0] = num[0] + info[i][j];
//									}
//									else if(  ((i<3 && j>=5)||(i==3)) && info[i][j] > 0 )//萬筒條序號大於等於5，或是字
//									{
//									    num[x] = i*10 + (j-1);//計入廢牌
//									    x++;
//									}
//							}
//							
//					for( int i=0; i<3; i++ )//萬筒條序數 < 5，都是缺牌
//					    for( int j=1; j<5; j++ )
//					        {
//						        num[y] = i*10 + (j-1);//缺一張，計入缺牌
//							    y++;
//						    }
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[36]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				case SanFengKe://37.三風刻，胡了再檢查有無0.大四喜、8.小四喜
//				{
//				    if( chiPeng > 0 )
//					    {
//						    int chi = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃
//								    {
//									    chi++;
//									}
//									else
//								    {
//										if( source[i*3]>=30 && source[i*3]<=33 )//有風刻
//										    num[0] = num[0] + 3;
//									}
//						    }
//							if( chi >= 2 )//2組吃，無法成立
//							{
//							    break;
//							}
//						}
//					
//					for( int i=1; i<=4; i++ )
//					    {
//						    if( info[3][i]>1 )//手牌未吃碰同風牌有2張以上
//							    num[0] = num[0] + info[3][i];
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					break;
//				}
//				
//				case HuaLong://38.花龍：49.三色三步高差距為3的版本，返回0-9，有記缺牌
//				{
//				    int[][] shun = new int[3][7];//萬筒條字7種順的數量
//				    if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    peng++;
//									}
//									else//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//							if( peng >= 2 )//2組碰，花龍無法成立
//							{
//							    break;
//							}
//						}
//						
//					int[][] idx = {//配合下方迴圈，可得知符合數
//					                {0,1,2,},//萬筒條
//					                {0,2,1,},//萬條筒
//					                {1,0,2,},//筒萬條
//					                {1,2,0,},//筒條萬
//					                {2,0,1,},//條萬筒
//					                {2,1,0,},//條筒萬
//					              };
//					int sum = 0;
//					for(int i=0; i<6; i++)//idx 6組
//					    {
//						        int[] k = idx[i];
//							    int[] temp = {
//                      						   0,
//		                                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                          -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//											  };
//								int temp_x = 1;
//								int temp_y = 15;
//								
//							    for( int s=0; s<3; s++ )
//								    {
//									    for( int t=0; t<3; t++ )//  idx[0]	的順序：萬筒條 => 123萬+456筒+789條
//										    {
//											    if( shun[k[s]][s*3] > 0 )//此順已有吃了
//												    {
//													    sum = sum + 3;
//														break;
//													}
//											    int w = ( info[k[s]][0+1+s*3+t] > 0 ) ? 1 : 0;
//												sum = sum + w;
//												if( w==0 )
//												    {
//													    temp[temp_y] = s*10 + 1 + s + t -1;//記入缺牌
//														temp_y++;
//													}
//											}
//									}
//								if( sum > num[0] )
//								    {
//									    num = temp;
//									    num[0] = sum;
//									}
//								sum = 0;
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[38]+"符合數:"+num[0]);
//					break;
//				}
//				
//				case TuiBuDao://39.推不倒：1234589筒 + 245689條 + 白板，有廢牌，無缺牌
//				{
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    int s = source[i];
//							if( s == -10 || s == -11 ) s = source[i+1];//槓牌標誌轉換
//						    if( s==10 || s==11 || s==12 || s==13 || s==14 || s==17 || s==18 || s==21 || s==23 || s==24 || s==25 || s==27 || s==28 || 
//							    (s==36&&info[3][6]>1) )
//							    {
//									if( s!=36 ) num[0]++;
//									    else num[0] = num[0] + info[3][6];//白板要2張才算
//								}
//								else
//								{
//								    num[x] = s;//計入廢牌
//									x++;
//								}
//						}
//					num[15] = 10;  num[16] = 11;  num[17] = 12;  num[18] = 13;  num[19] = 14;  num[20] = 17;  num[21] = 18;
//					num[22] = 21;  num[23] = 23;  num[24] = 24;  num[25] = 25;  num[26] = 27;  num[27] = 28;  num[28] = 36;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[39]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				case SanShaiSanTongShun://40.三色三同順 ，有缺牌，無廢牌
//				{
//				    int[][] shun = new int[3][7];//萬筒條7種順的數量
//				    if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    peng++;
//									}
//									else//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//							if( peng >= 2 )//2組碰，三色三同順無法成立
//							{
//							    break;
//							}
//						}
//					/*以下尋找三花色的123、三花色的234、三花色的345......、*/
//					for( int i=1; i<=7; i++ )//1-7的順頭
//					    {
//						    int sum = 0;
//							int[] temp = {
//                      					   0,
//		                                  -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//										  };
//							int temp_x = 1;//廢牌索引
//							int temp_y = 15;//缺牌索引
//							
//						    for( int j=0; j<=2; j++ )//3花色
//							    {
//								    if( shun[j][i-1] > 0 )//此花色之順已有吃了
//										{
//											sum = sum + 3;
//										}
//										else
//										{
//										    sum = info[j][i]  >0 ? sum+1 : sum;
//											sum = info[j][i+1]>0 ? sum+1 : sum;
//											sum = info[j][i+2]>0 ? sum+1 : sum;
//										}
//										
//						            if( info[j][i] == 0 )
//									    {
//										    temp[temp_y] = j*10 + i - 1;//缺的牌
//											temp_y++;
//										}
//								}
//							if( sum > num[0] )
//							    {
//								    num[0] = sum;
//									for( int j=15; j<=28; j++ )
//									    {
//										    num[j] = temp[j];
//										}
//								}
//							sum = 0;
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[40]+"符合數:"+num[0]);
//					break;
//				}
//				
//				case SanShaiSanJieGao://41.三色三節高，無缺廢牌，返回0-9
//				{
//				    if( chiPeng > 0 )
//					    {
//						    int chi = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃
//								    {
//									    chi++;
//									}
//									else//有碰，把資料塞回關聯表
//								    {
//										int a = source[i*3]/10;
//										int b = source[i*3]%10+1;
//										info[a][b] = info[a][b] + 3;//槓也算3張
//									}
//						    }
//							if( chi >= 2 )//2組吃，三色三節高無法成立
//							{
//							    break;
//							}
//						}
//						
//					int[][] idx = {//配合下方迴圈，可得知符合數
//					                {0,1,2,},//萬筒條
//					                {0,2,1,},//萬條筒
//					                {1,0,2,},//筒萬條
//					                {1,2,0,},//筒條萬
//					                {2,0,1,},//條萬筒
//					                {2,1,0,},//條筒萬
//					              };
//					int sum = 0;
//				    for(int i=0; i<6; i++)//idx 6組
//					    {
//						    int[] k = idx[i];
//						    for(int j=1; j<=7; j++)//刻組 123.234.345....789
//							{
//							    int a = info[k[0]][j]   > 1 ? info[k[0]][j]   : 0;//單張不計
//							    int b = info[k[1]][j+1] > 1 ? info[k[1]][j+1] : 0;
//							    int c = info[k[2]][j+2] > 1 ? info[k[2]][j+2] : 0;
//							    sum = a + b + c;//  idx[0]	的順序：萬筒條 => 1萬+2筒+3條
//								if( sum > num[0] )
//								    {
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[41]+"符合數:"+num[0]);
//					break;
//				}
//				
//				//case 42 為胡牌後都沒番
//				//case 43-46 為胡牌後胡的牌狀態判定，妙手回春、海底撈月、槓上開花、搶槓和
//				
//                case PengPengHe://47.碰碰和
//				{
//					if( IsHu )
//					    {
//						    for( int ph=0; ph<=PaiAnalysis.hu.length-5; ph++ )
//							    {
//								    if( ph%3==0 && PaiAnalysis.hu[ph]!=PaiAnalysis.hu[ph+2])//胡牌陣列中有順子==>>不是碰碰胡
//									    {
//										    num[0]=0;
//											return num;
//										}
//									if( ph==9 )//會執行至此，表示0.3.6.9的組合均無順子，若有順子，於上方已跳開
//									    {
//										    num[0]=14;
//											return num;
//										}
//								}
//						}
//					int peng = 0;//碰的數量，碰槓最多只會有4次，避免類似<七對>牌型造成誤判
//					if( chiPeng > 0 )//有吃碰 => 計算明牌的碰牌
//					    {
//						    int cp = chiPeng / 3;//吃碰組數，此處至少為1
//						    for( int i=0; i<cp; i++)
//							    {
//								    if( source[i*3]==source[i*3+2] )//吃碰組的頭等於尾 => 碰2.2.2、明槓2.-10.2、暗槓2.-11.2
//									    {
//										    peng++;
//											num[0] = num[0] + 3;
//										}
//								}
//								
//							if( cp != peng )//吃碰數量不等於碰 => 有吃 => 不成立
//							    {
//								    num[0] = 0;
//								    break;
//								}
//						}
//						
//					//num[0] = num[0] + chiPeng;//執行至此，表示指針之前都是碰
//						
//					for( int i=0; i<4; i++ )//計算手牌萬筒條字的刻
//					    for( int j=1; j<info[i].length; j++ )//各序號數量
//					        {
//							    if( info[i][j] > 2 && peng <= 4 )//同樣的手牌有3張或4張，當作3張(因為4張要暗槓掉才算1刻)。碰槓最多只有四次，超過不計，避免類似<七對>牌型造成誤判。
//								    {
//									    num[0] = num[0] + 3;
//										peng++;
//									}
//								    else if( info[i][j] == 2 && peng < 4 )//同樣的手牌有2張
//								    {
//									    num[0] = num[0] + 2;
//										peng++;
//										num[y] = i*10 + (j-1);//缺一張，計入缺牌
//									    y++;
//									}
//								    else if( info[i][j] > 1 && peng >= 4 )//同樣的手牌有2張，第五碰(含2缺1的牌)，符合數不計，只計缺牌(可碰)
//								    {
//									    if( peng == 4 )//4碰(含2缺1的牌)已滿，當作將
//										    {
//											    num[0] = num[0] + 2;
//										        peng++;//將
//											}
//									    
//										    num[y] = i*10 + (j-1);//缺一張，計入缺牌
//									        y++;
//									}
//									else if( info[i][j] == 1 )//一張的算廢牌
//									{
//									    num[x] = i*10 + (j-1);
//									    x++;
//									}
//						    }
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[47]+"符合數:"+num[0]);
//			        break;
//				}
//				
//				case HunYiShai://48.混一色
//				{
//					int[] qing = { 0, 0, 0, 0 };//萬筒條字的數量
//					if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3]==source[i*3+2] && source[i*3]>=30 )//有碰槓字
//								    {
//									   qing[3] = qing[3] + 3;
//									}
//						    }
//						}
//					for( int i=1; i<=7; i++ )//手牌未吃碰的字，至少2張才算
//					    {
//						    if( info[3][i]>1 ) qing[3] = qing[3] + info[3][i];
//						}
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] == -10 || source[i] == -11 )//槓
//							    {
//								    source[i] = source[i+1];//槓牌中間的牌轉換標誌
//								}
//							int cate = source[i]/10;
//						    if( cate <3 ) qing[cate]++;
//						}
//					
//					int max = qing[0];
//					if( qing[0] < qing[1] ) max = qing[1];
//					if( max < qing[2] ) max = qing[2];
//					
//					num[0] = max + qing[3];
//					if( qing[3]==0 || ( qing[0]==0&&qing[1]==0&&qing[2]==0 ) ) num[0] = 0;//沒字或全字不是混一色
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("混一色符合數:"+num[0]);
//					break;
//				}
//				
//				case SanShaiSanBuGao://49.三色三步高，返回0-9，有記缺牌
//				{
//				    int[][] shun = new int[3][7];//萬筒條字7種順的數量
//				    if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰槓
//								    {
//									    peng++;
//									}
//									else//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//							if( peng >= 2 )//2組碰，三色三步高無法成立
//							{
//							    break;
//							}
//						}
//						
//					int[][] idx = {//配合下方迴圈，可得知符合數
//					                {0,1,2,},//萬筒條
//					                {0,2,1,},//萬條筒
//					                {1,0,2,},//筒萬條
//					                {1,2,0,},//筒條萬
//					                {2,0,1,},//條萬筒
//					                {2,1,0,},//條筒萬
//					              };
//								  
//					int sum = 0;
//				    for(int i=0; i<6; i++)//idx 6組，此回圈檢查idx花色順序組合
//					    {
//						    int[] k = idx[i];
//						    for(int j=1; j<=5; j++)//順的頭張分別為 123.234.345.456.567
//							{
//							    int[] temp = {
//                      						   0,
//		                                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                          -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//											  };
//								int temp_x = 1;
//								int temp_y = 15;
//								
//							    for( int s=0; s<3; s++ )
//								    {
//									    for( int t=0; t<3; t++ )//  idx[0]	的順序：萬筒條 => 123萬+234筒+345條
//										    {
//											    if( shun[k[s]][j+s-1] > 0 )//此順已有吃了
//												    {
//													    sum = sum + 3;
//														break;//此組已吃，檢查下一組
//													}
//											    int w = ( info[k[s]][0+j+s+t] > 0 ) ? 1 : 0;
//												sum = sum + w;
//												if( w==0 )
//												    {
//													    temp[temp_y] = s*10 + j + s + t -1;//記入缺牌
//														temp_y++;
//													}
//											}
//									}
//								if( sum > num[0] )//EX：j=1，檢查完idx[i]花色的123,234,345
//								    {
//									    num = temp;
//									    num[0] = sum;
//									}
//								sum = 0;
//							}
//							
//							/*for(int j=1; j<=3; j++ )//順頭 135.246.357
//							{
//							    int[] temp = {
//                      						   0,
//		                                      -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//					                          -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//											  };
//								int temp_x = 1;
//								int temp_y = 15;
//								
//							    for( int s=0; s<3; s++ )
//								    {
//									    for( int t=0; t<3; t++ )//  idx[0]	的順序：萬筒條 => 123萬+345筒+567條
//										    {
//											    if( shun[k[s]][j+s*2-1] > 0 )//此順已有吃了
//												    {
//													    sum = sum + 3;
//														break;
//													}
//											    int w = ( info[k[s]][0+j+s*2+t] > 0 ) ? 1 : 0;
//												sum = sum + w;
//												if( w==0 )
//												    {
//													    temp[temp_y] = s*10 + j + s + t -1;//記入缺牌
//														temp_y++;
//													}
//											}
//									}
//								if( sum > num[0] )
//								    {
//									    num = temp;
//									    num[0] = sum;
//									}
//								sum = 0;
//							}*/
//						}
//					num[0] = num[0] + CONST_CUSTOMIZE.checkOnece_9_PLUS;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println(Fan[49]+"符合數:"+num[0]);
//					break;
//				}
//				
//				case WuMenQi://50.五門齊：三花色 + 風 + 箭。成立為1，不成立為0，無缺廢牌。只要同風*2 + 同箭 *2 可避免特殊組合重複EX：七星不靠、13么
//				{
//					boolean wang = false, tong = false, tiau = false, feng = false, jian = false;
//					if( chiPeng > 0 )
//					for( int i=0; i<chiPeng/3; i++ )
//					    {
//						    if( source[i*3]/10==0 )  wang = true;
//							else if( source[i*3]/10==1 )  tong = true;
//							else if( source[i*3]/10==2 )  tiau = true;
//							else if( source[i*3]/10==3 )
//							    {
//								    if( source[i*3]%10 <= 3 ) feng = true;
//									else if( source[i*3]%10 > 3 && source[i*3]%10 <= 6 ) jian = true;
//								}
//						}
//					for( int i=0; i<3; i++ )
//					    {
//						    if( info[i][0] > 0 )
//							    {
//								    if( i==0 ) wang = true;
//									else if( i==1 ) tong = true;
//									else if( i==2 ) tiau= true;
//								}
//						}
//					
//					if( wang && tong && tiau )//萬筒條都有
//					    {
//						    for( int i=1; i<=7; i++ )
//							    {
//								    if( i <= 4 && info[3][i] > 1 )//風有1張以上
//									    {
//										    feng = true;
//										}
//										else if( i > 4 && info[3][i] > 1 )//箭有1張以上
//										{
//										   jian = true;
//										}
//								}
//							if( feng && jian )
//							    {
//								    num[0] = 1;
//								}
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("五門齊："+IsExist(num[0]) );
//			        break;
//				}
//				
//                case QuanQiuRen://51.全求人：不可暗槓
//				{
//				    boolean fail = false;
//				    if( chiPeng > 0 )
//				        for( int i=0; i<chiPeng; i++ )
//					        {
//						        if( source[i] == -11 )//暗槓：中間牌的記號
//								    {
//									    fail = true;
//									    num[0] = 0;
//								        break;
//									}
//						    }
//							
//					if( fail ) break;
//				    num[0] = chiPeng + 2;//chiPeng=12=吃碰槓4組(12張) + 1 將，chiPeng=9=吃碰槓3組(9張) + 1 將...
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_ONECE ) System.out.println("全求人符合數"+num[0]);
//			        break;
//				}
//				
//				case ShuangAnGang://52.雙暗槓：前置66.暗槓，成立為1，不成立為0
//				{
//				    if( chiPeng > 0 )
//				    for( int i=0; i<chiPeng; i++ )
//					    {
//						    if( source[i]==-11 )
//							    {
//								    num[0]++;
//								}
//						}
//					if( num[0] > 1 ) num[0] = 1;
//					    else num[0] = 0;
//					break;
//				}
//				
//				case ShuangJianKe://53.雙箭刻：前置58.箭刻，成立為1，不成立為0
//				{
//					int sjk = 0;
//					for( int i=0; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]==hu[i*3+2] && hu[i*3]>=34 && hu[i*3]<=36 ) sjk++;
//						}
//					if( sjk >= 2 ) num[0] = 1;
//					break;
//				}
//				
//				case ShuangMingGang://56.雙明槓：成立為1，不成立為0
//				{
//				    if( chiPeng > 0 )
//				    for( int i=0; i<chiPeng; i++ )
//					    {
//						    if( source[i]==-10 )
//							    {
//								    num[0]++;
//								}
//						}
//					if( num[0] > 1 ) num[0] = 1;
//					    else num[0] = 0;
//					break;
//				}
//				
//				//case 57 為胡牌後胡的牌狀態判定
//				
//				case JianKe://58.箭刻：成立為1，不成立為0
//				{
//				    for( int i=0; i<source.length-2; i++ )
//					    {
//						    if( source[i] == source[i+2] && source[i]>=34 )
//							    {
//								    num[0] = 1;
//									break;
//								}
//							    
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("箭刻："+IsExist(num[0]) );
//					break;
//				}
//				
//				case QuanFengKe://59.圈風刻：成立為1，不成立為0
//				{
//				    for( int i=0; i<source.length-2; i++ )
//					    {
//						    if( source[i] == source[i+2] && source[i]>=30 && source[i]%10==quanFeng )
//							    {
//								    num[0] = 1;
//									break;
//								}
//							    
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("圈風刻："+IsExist(num[0]) );
//				    break;
//				}
//				
//				case MenFengKe://60.門風刻：成立為1，不成立為0，莊家為東風，依序為南西北風
//				{
//				    for( int i=0; i<source.length-2; i++ )
//					    {
//						    if( source[i] == source[i+2] && source[i]>=30 && source[i]%10==(player+4-LGame.banker)%4 )
//							    {
//								    num[0] = 1;
//									break;
//								}
//							    
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("門風刻："+IsExist(num[0]) );
//				    break;
//				}
//				
//				case MenQianQing://61.門前清(非自摸)
//				{
//				    num[0] = 1;
//				    if( chiPeng > 0 )//chiPeng大於0卻可成立，只有都是暗槓才行，任1不是暗槓則無法成立
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3+1] != -11 )//有吃碰，但中間牌的記號不是暗槓 = > 不成立
//								    {
//									    num[0] = 0;
//								        break;
//									}
//						    }
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("門前清OR不求人："+IsExist(num[0]) );
//					break;
//				}
//				
//				case SiQuiYi://63.四歸一，可重複計算，四張非槓，成立為1，不成立為0，無缺廢牌
//				{
//				    int[] sqy = new int[14];
//					for( int i=0; i<14; i++ ) sqy[i] = source[i];
//					liPai( sqy, 0, 13);//槓標記-10-11會被排到最前面
//					for( int i=0; i<sqy.length-3; i++ )
//					    {
//						    if( sqy[i] >= 0 && sqy[i] == sqy[i+3] )//不是槓，排序後隔2張還是相同的牌 = > 成立 ，槓牌是3.-10.3 或 3.-11.3，不是3.3.3.3
//							    {
//								    num[0] = num[0]+1;
//								}
//						}
//					if( num[0] >1 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("四歸一："+IsExist(num[0]) );
//					break;
//				}
//				
//				case ShuangTongKe://64.雙同刻
//				{
//				    if( chiPeng > 0 )
//					    {
//						    int chi = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] == source[i*3+2] )//有碰，把資料塞回關聯表
//								    {
//										int a = source[i*3]/10;
//										int b = source[i*3]%10+1;
//										info[a][b] = info[a][b] + 3;//槓也算3張
//									}
//						    }
//						}
//						
//					for( int i=1; i<=9; i++ )
//					    {
//						    int tmp = 0;
//						    for( int j=0; j<=2; j++ )
//							    {
//								    if( info[j][i] >=3 )  tmp++;
//								}
//							if( tmp>=2 ) num[0]++;
//						}
//					if( num[0] >1 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("雙同刻："+IsExist(num[0]) );
//					break;
//				}
//				
//				case ShuangAnKe://65.雙暗刻：成立為1，不成立為0
//				{
//				    int sak = 0;
//					//int sak2 = 0;
//					int sak3 = 0;
//				    if( chiPeng > 0 )//檢查暗槓
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3+1] == -11 )//是暗槓
//								    {
//									    sak++;
//									}
//						    }
//						}
//					
//					/*for( int i=chiPeng/3; i<hu.length/3; i++ )
//					    {
//						    if( hu[i*3]==hu[i*3+2] ) sak2++;
//						}*/
//					for( int i=0; i<=3; i++ )//四花色
//					    {
//						    for( int j=1; j<=9; j++ )
//							    if( info[i][j]>=3 )//111222333=>123123123，所以要檢查手牌
//							        {
//								        sak3++;
//								    }
//						}
//					//if( sak2 > sak3 ) sak = sak + sak2;
//					    //else 
//						sak = sak + sak3;
//					if( sak >= 2 ) num[0] = 1;
//						else num[0] = 0;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("雙暗刻："+IsExist(num[0]) );
//					break;
//				}
//				
//				case AnGang://66.暗槓，成立為1，不成立為0。
//				{
//				    if( chiPeng > 0 )
//				    for( int i=0; i<chiPeng; i++ )
//					    {
//						    if( source[i]==-11 )
//							    {
//								    num[0]++;
//									break;
//								}
//						}
//					if( num[0] > 0 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("暗槓："+IsExist(num[0]) );
//					break;
//				}
//				
//				case DuanYao://67.斷么：沒有1.9.字，成立為1，不成立為0
//				{
//				    num[0] = 1;
//					for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] <= 28 && ( source[i]%10==0 || source[i]%10==8 ) )//1 OR 9
//							    {
//								    num[0] = 0;
//									break;//不成立，停止判斷
//								}
//							    else if( source[i] > 28 )//是字牌
//							    {
//								    num[0] = 0;
//									break;//不成立，停止判斷
//								}
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("斷么："+IsExist(num[0]) );
//					break;
//				}
//				
//				case YiBanGao://68.一般高：同花之同順
//				{
//					int[][] shun = new int[3][7];//萬筒條字7種順的數量
//					    
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃，檢查吃組之頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//											
//										shun[head/10][head%10]++;
//									}
//						    }
//						}
//						
//					for( int i=0; i<=2; i++ )//依序檢查萬筒條的所有順
//					    {
//						    for( int j=1; j<=7; j++ )
//							    {
//								    if( info[i][j] > 0 && info[i][j+1] > 0 && info[i][j+2] > 0 )
//									    {
//										    shun[i][j-1]++;
//											if( info[i][j] > 1 && info[i][j+1] > 1 && info[i][j+2] > 1 )//EX：334455，333444555就是1色3同順了，不用算一般高
//											    {
//												    shun[i][j-1]++;
//												}
//										}
//								}
//						}
//						
//					for( int i=0; i<=2; i++ )//檢查所有順數量是否有2以上
//					    for( int j=0; j<=6; j++ )
//						    {
//							    if( shun[i][j] > 1 )  num[0]++;
//							}
//					if( num[0]>1 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("一般高："+IsExist(num[0]) );
//					break;
//				}
//				
//				case XiXiangFeng://69.喜相逢：異花色之同順，最多2
//				{
//				    int[][] shun = new int[3][7];//萬筒條字7種順的數量
//					if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//						}
//						
//					for( int i=0; i<=2; i++ )//萬筒條
//					    {
//						    for( int j=1; j<=7; j++ )//7種順頭
//							    {
//								    if( info[i][j]>0 && info[i][j+1]>0 && info[i][j+2]>0 )
//									    {
//										    shun[i][j-1]++;//紀錄手牌有的順
//										}
//								}
//						}
//					
//					for( int i=0; i<=6; i++ )
//					    {
//						    int tmp = 0;
//						    for( int j=0; j<=2; j++ )
//							    {
//								    if( shun[j][i] > 0 ) tmp++;
//								}
//							if( tmp==2 ) num[0]++;//只有2花色有順，3花色有就算三同順了
//						}
//					if( num[0]>1 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("喜相逢："+IsExist(num[0]) );
//					break;
//				}
//				
//				case LianLu://70.連六：1花色最多1連六
//				{
//				    int[][] shun = new int[3][7];//萬筒條7種順的數量
//					if( chiPeng > 0 )
//					    {
//						    int peng = 0;
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃，記錄吃的順頭
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//										shun[head/10][head%10]++;
//									}
//						    }
//						}
//						
//					for( int i=0; i<=2; i++ )//萬筒條
//					    {
//						    for( int j=1; j<=7; j++ )//7種順頭
//							    {
//								    if( info[i][j]>0 && info[i][j+1]>0 && info[i][j+2]>0 )
//									    {
//										    shun[i][j-1]++;//紀錄手牌有的順
//										}
//								}
//						}
//					
//					for( int i=0; i<=2; i++ )//萬筒條
//					    {
//						    for( int j=0; j<4; j++ )//1+4.2+5.3+6.4+7
//							    {
//								    if( shun[i][j]>0 && shun[i][j+3]>0)//EX: 234+567
//									    {
//										    num[0]++;
//											break;//1花色最多1連六
//										}
//								}
//						}
//					if( num[0]>1 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("連六："+IsExist(num[0]) );
//					break;
//				}
//				
//				case LaoShaoFu://71.老少副：同花色123+789，成立為1，不成立為0。無缺廢牌
//				{
//				    int[][] set = {
//					                 {0,0},//萬筒條的123+789
//					                 {0,0},
//					                 {0,0},
//								  };
//				    if( chiPeng > 0 )
//					    {
//						    for( int i=0; i<( chiPeng / 3 ); i++ )
//					        {
//						        if( source[i*3] != source[i*3+2] )//有吃，檢查吃組是否為123或789
//								    {
//										int head = source[i*3];
//										if( source[i*3+1] < head ) head = source[i*3+1];
//										if( source[i*3+2] < head ) head = source[i*3+2];
//											
//										if( head%10 == 0 )//123
//										    {
//											    set[source[i*3]/10][0]++;
//											}
//											else if( head%10 == 6 )//789
//											{
//											    set[source[i*3]/10][1]++;
//											}
//									}
//						    }
//						}
//						
//					for( int i=0; i<=2; i++ )//依序檢查萬筒條的123+789
//					    {
//						    for( int j=0; j<=3; j++ )//同花色最多同時有4個123
//							    {
//								    if( info[i][1]-j>0 && info[i][2]-j>0 && info[i][3]-j>0 )//各減 j 個 仍不會是負的，表示該順可以疊加 j+1 次
//							            {
//								            set[i][0]++;
//								        }
//										else
//										{
//										    break;//有為負的：已無123順
//										}
//								}
//						    for( int j=0; j<=3; j++ )//同花色最多同時有4個789
//							    {
//								    if( info[i][7]-j>0 && info[i][8]-j>0 && info[i][9]-j>0 )//各減 j 個 仍不會是負的，表示該順可以疊加 j+1 次
//							            {
//								            set[i][1]++;
//								        }
//										else
//										{
//										    break;//有為負的：已無789順
//										}
//								}
//						}
//						
//					for( int i=0; i<=2; i++ )
//					    {
//						    if( set[i][0] > set[i][1] )//取各花色123.789順中較少者為老少副存在數
//							    {
//								    num[0] = num[0] + set[i][1];
//								}
//								else
//								{
//								    num[0] = num[0] + set[i][0];
//								}
//						}
//						
//					if( num[0] > 0 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("老少副："+IsExist(num[0]) );
//					break;
//				}
//				
//				case YaoJiuKe://72.么九刻：1.9刻，非門風圈風的風刻
//				{
//				    for( int i=0; i<source.length; i++ )
//					    {
//						    if( i+2 < source.length && source[i] == source[i+2] )
//							    {
//									if( source[i] < 30 && ( source[i]%10==0 || source[i]%10==8 ) )//三花色的1.9刻
//									    {
//										    num[0]++;
//										}
//										else if( source[i] >= 30 && source[i] <= 33 && source[i]%10!=quanFeng && source[i]%10!=(player+4-LGame.banker)%4 )//風刻非圈風門風
//										{
//										    num[0]++;
//										}
//								}
//						}
//					
//					if( num[0] > 0 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("么九刻："+IsExist(num[0]) );
//					break;
//				}
//				
//				case MingGang://73.明槓，成立為1，不成立為0。
//				{
//				    if( chiPeng > 0 )
//				    for( int i=0; i<chiPeng/3; i++ )
//					    {
//						    if( source[i*3+1]==-10 )
//							    {
//								    num[0]++;
//									break;
//								}
//						}
//					if( num[0] > 0 ) num[0] = 1;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("明槓："+IsExist(num[0]) );
//					break;
//				}
//				
//				case QueYiMen://74.缺一門：萬筒條缺1種，成立為1，不成立為0，無缺廢牌
//				{
//				    num[0] = 1;
//					boolean wang = false;
//					boolean tong = false;
//					boolean tiau = false;
//					for( int i=0; i<source.length; i++ )
//					    {
//						    int qym = source[i]/10;
//						    if( qym == 0 ) wang = true;
//							else if( qym==1 ) tong = true;
//							else if( qym==2 ) tiau = true;
//						}
//					
//					int rst = 0;
//					rst = wang ? rst + 1 : rst;
//					rst = tong ? rst + 1 : rst;
//					rst = tiau ? rst + 1 : rst;
//					
//					if( rst != 2 )  num[0] = 0;
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("缺一門："+IsExist(num[0]) );
//					break;
//				}
//				
//				case WuZi://75.無字，成立為1，不成立為0
//				{
//				    num[0] = 1;
//					for( int i=0; i<source.length; i++ )
//					    {
//						    if( source[i] > 28 )//是字牌
//							    {
//								    num[0] = 0;
//									break;//不成立，停止判斷
//								}
//						}
//					if( CONST_CUSTOMIZE.TRACE_CODE && CONST_CUSTOMIZE.TRACE_CHECK_OFTEN && num[0]!=0 ) System.out.println("無字："+IsExist(num[0]) );
//					break;
//				}
//				
//				//case 76,77,78,79 為胡牌後胡的牌狀態判定
//				//case 80 花牌，胡牌後才算
//				case -1:
//				case -2:
//				    num[0]=0;
//				    break;
//		        default:
//				    System.out.println("PaiAnalysis.checkType WRONG!! target="+target);
//					break;
//			}
//			}catch(Exception e)
//			    { 
//				    System.out.println("chiPeng="+chiPeng+"_target="+target+"_"+e); 
//					System.out.println("player="+player+"_IsHu="+IsHu);
//					for(int q=0;q<14;q++)
//					    System.out.print("_"+source_x[q]);
//						System.out.println("_+_");
//				}
//		return num;
//	}
//	
//	
//	/**回傳該牌陣列中符合3+2的最高符合數，EX：已剔除符合組合龍的牌(被剔除的牌標示為-1)，剩餘的在此檢查最高符合數，回傳值為2-5
// 	*@param left 要檢查的牌陣列
// 	*@return int[] index 0為符合數，index 1-14 為廢牌代碼
// 	*/
//	/*private static int checkLeftPai( int[] left )
//	{
//	    //符合數：F，先找是否有1對
//		//若有1對<F+2>，則再找刻或順<F+3>、刻缺1或順缺1<F+2>、刻缺2或順缺2<F+1>
//		//若無1對<F+1>，則再找刻或順<F+3>、刻缺1或順缺1<F+2>、刻缺2或順缺2<F+1>
//		boolean yiDui = false;//是否發現一對
//		int fu = 0;
//		int fu_tmp = 0;//暫存找到的最大符合數
//		liPai(left, 0, left.length-1);//陣列長度若為10，index最大為9
//		
//		for( int i=0; i<=left.length-2; i++ )//找1對，陣列長度若為10，index最大為9，最多找到index 8
//		    {
//			    if( left[i] != -1 && left[i] == left[i+1] )//有1對，有一對的所有狀況，最多5張，最少有3張：1對 + 1張。
//				    {
//					    fu_tmp = fu_tmp + 2;
//					    if( i+2 <= left.length-1 && left[i] == left[i+2] )//陣列長度若為10，index最大為9，i+2 不能大於9，i+2 存在且有刻
//						    {
//							    fu_tmp = fu_tmp + 1;//以為是對，結果是刻，+1
//								        int cate = left[i] / 10;
//										if( cate < 3 )//不是字牌，有刻，檢查刻的第三張是否為順頭、順中或順尾
//										    {
//											    boolean b1=false, b2=false, b3=false, b4=false;
//											    if( i-1 >= 0               && left[i-1]   == left[i]-1 ) b1 = true;//EX：4萬前面有3萬 => 2==3-1
//												if( i-2 >= 0               && left[i-2]   == left[i]-2 ) b2 = true;//EX：4萬前面有2萬
//											    if( i+2+1 <= left.length-1 && left[i+2+1] == left[i]+1 ) b3 = true;//EX：4萬後面有5萬
//												if( i+2+2 <= left.length-1 && left[i+2+2] == left[i]+2 ) b4 = true;//EX：4萬後面有6萬
//												if( (b1 && b2) || (b3 && b4) || (b1 && b3) )//順尾 或 順頭 或 順中
//												    {
//													    fu_tmp = fu_tmp + 2;//一對 + 一順
//														//fu = fu_tmp;
//														break;
//													}
//													else if( b1 || b2 || b3 || b4 )//雙頭順或中洞
//													{
//													    fu_tmp = fu_tmp + 1;
//													}
//											}
//								if( (i+2)+2 <= (left.length-1) )//陣列長度若為10，index最大為9，已有刻，i+2後面若還有2張以上才需檢查是否有對
//								    {
//									    for( int k=(i+2)+1; k<=left.length-2; k++ )//找1對，陣列長度若為10，index最大為9，最多找到index 8，起始位置為剛找到的刻後面的牌
//										    {
//											    if( left[i] != -1 && left[k] == left[k+1] )//有1對
//												    {
//													    fu_tmp = fu_tmp + 2;//一刻 + 一對
//														yiDui = true;
//														break;
//													}
//											}
//										if( yiDui ) 
//										    {
//											    fu = fu_tmp;
//												break;
//											}
//									}
//								
//							}
//							else//有1對，不成刻，對子本身亦無成順的可能：開始找以外的順或刻，分開找，求最大值
//							{
//							    //int temp = 2;//暫存找到的最大符合數(1對)
//								
//							    for( int j=0; j<=left.length-2; j++ )//陣列長度若為10，index最大為9，最多找到index 8
//								    {int temp = 2;//暫存找到的最大符合數(1對)
//									    //找刻子
//									    if( left[j] != -1 && left[j] != left[i] && left[j] == left[j+1] )//另1組對子
//										    {
//											    temp = temp + 2;
//											    if( j+2 <= left.length-1 && left[j] == left[j+2] )//發現刻子
//												    {
//													    temp = temp + 1;//以為是對，結果是刻，+1，3+2 找完>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>結束
//														break;
//													}
//													else//不是刻子，只是一對
//													{
//													    break;
//													}
//											}
//										//找順子，先排除字牌及已找到不成刻的1對
//										int cate = left[j] / 10;
//										if( cate < 3 && left[j] != left[i] )//非字牌、非上面的一對
//										    {
//											    boolean b1=false, b2=false, b3=false, b4=false;
//											    if( j-1 >= 0               && left[j-1]   == left[j]-1 ) b1 = true;//EX：4萬前面有3萬 => 2==3-1
//												if( j-2 >= 0               && left[j-2]   == left[j]-2 ) b2 = true;//EX：4萬前面有2萬
//											    if( j+2+1 <= left.length-1 && left[j+2+1] == left[j]+1 ) b3 = true;//EX：4萬後面有5萬
//												if( j+2+2 <= left.length-1 && left[j+2+2] == left[j]+2 ) b4 = true;//EX：4萬後面有6萬
//												if( (b1 && b2) || (b3 && b4) || (b1 && b3) )//順尾 或 順頭 或 順中
//												    {
//													    temp = temp + 3;//一對 + 一順
//														yiDui = true;//5張了=.=
//														break;
//													}
//													else if( b1 || b2 || b3 || b4 )//雙頭順或中洞
//													{
//													    temp = temp + 2;
//													}
//											}
//										if( temp > fu )
//										    {
//											    fu = temp;//取較大的值
//												temp = 2;//回到剛進來的值
//											}
//									}
//								if( yiDui ) break;//5張了=.=
//							}
//					}
//					
//				if( fu_tmp > fu )
//				    {
//					    fu = fu_tmp;
//					}
//				fu_tmp = 0;
//			}
//			
//			//若上面已有5張，下面不用算了，因為計算結果最多就是5張
//			//下面因為沒有對子所以最多只有4張< 1順 + 1眼 >，所以fu == 4 下面也不用算了
//			if( fu < 4 )//沒有對子，，找順子
//			    {
//				    int temp2 = 0;
//				    for( int i=0; i<=left.length-1; i++ )//找順、順缺1，陣列長度若為10，index最大為9，最多找到index 9
//					    {
//							int cate = left[i] / 10;
//							if( cate < 3 && left[i] != -1 )//非字牌、空牌
//							    {
//									boolean b1=false, b2=false, b3=false, b4=false;
//									if( i-1 >= 0               && left[i-1]   == left[i]-1 ) b1 = true;//EX：4萬前面有3萬 => 2==3-1
//									if( i-2 >= 0               && left[i-2]   == left[i]-2 ) b2 = true;//EX：4萬前面有2萬
//									if( i+2+1 <= left.length-1 && left[i+2+1] == left[i]+1 ) b3 = true;//EX：4萬後面有5萬
//									if( i+2+2 <= left.length-1 && left[i+2+2] == left[i]+2 ) b4 = true;//EX：4萬後面有6萬
//									if( (b1 && b2) || (b3 && b4) || (b1 && b3) )//順尾 或 順頭 或 順中
//										 {
//											temp2 = 4;//1順 + 1眼
//											break;//>>>>>>>>>已經最大，結束!!!!
//										}
//										else if( b1 || b2 || b3 || b4 )// 雙頭順或中洞
//											{
//											    temp2 = 3;// 順缺1 + 1眼
//											}
//										else if( !b1 && !b2 && !b3 && !b4 )
//										    {
//											    temp2 = 2;// 順缺2 + 1眼
//											}
//								}
//							
//							if( temp2 > fu )
//							    {
//								    fu = temp2;//取較大的值
//									temp2 = 0;
//								}
//						}
//				}
//			
//		if( fu > 5 ) System.out.println("checkLeftPai 計算錯誤!!!!   fu="+fu+"_"+left[0]+"_"+left[1]+"_"+left[2]+"_"+left[3]+"_"+left[4]+"_"+left[5]+
//		"_"+left[6]+"_"+left[7]+"_"+left[8]+"_"+left[9]+"_"+left[10]+"_"+left[11]+"_"+left[12]+"__"+left[13] );
//		
//		return fu;
//		
//	}*/
//
//	/**理牌，如果前面的牌比後面的大就對調
// 	*@param pai[] 要處理的牌陣列
// 	*@param begin 起始的位置(包含)
// 	*@param end 結束的位置(包含)
// 	*/
//    public static int[] liPai(int pai[], int begin, int end)
//	{ 
//      int tmp;
//      for (int i = begin; i < end; i++) 
//	  {
//        for (int j = i+1; j < end+1; j++) 
//		{
//          if (pai[i]> pai[j]) 
//		  {
//            tmp = pai[i];
//            pai[i] = pai[j];
//            pai[j] = tmp;
//          }
//        }
//      }
//     return pai;
//    }
//	
//	public static int pai_firstPlace( int[] pai, int val, int begin, int end )//在牌中間搜索一個牌的第1次出現的位置
//	{
//        for (int i = begin; i <= end; i++)
//          if (pai[i] == val)
//            return i;
//        return -1;
//    }
//	
//	private static String IsExist(int num)
//	{
//	    String AS = "成立";
//		String AD = "不成立";
//		String AF = "這是什麼鳥?";
//		if( num==0 ) return AD;
//		else if( num==1 ) return AS;
//		else return AF;
//	}
//	
//	/**檢查吃碰指針後方的牌是否符合3332的組合，所有-3去掉則適用16張MJ，處理完的牌，將眼在最後2 張，吃碰指針前的不變
// 	*@param pai[] 要處理的牌陣列
// 	*@param chipeng 起始的位置(包含)
// 	*/
//    public static boolean IsHuPai(int target[], int chipeng)
//	{ 
//	    for( int i=0; i<chipeng; i++ )
//		    {
//			    hu[i] = target[i];
//			} 
//		System.arraycopy(target, 0, pai, 0, target.length);
//		boolean hupai = jibenPutong2( chipeng, false );
//		
//		return hupai;
//    }
//	
//	private static boolean jibenPutong2(int i, boolean ydui)
//    {
//        //i：開始位置；ydui：是否有對子
//	    liPai(pai, i, 13);//理牌
//        if (!ydui && (pai[i] == pai[i + 1]))  //是否有對子
//		    {
//                if ( (i + 2 == 17-3) || (jibenPutong2(i + 2, true))) 
//				    {
//                        hu[15-3] = pai[i];
//                        hu[16-3] = pai[i];
//                        return true;
//                    }
//            }
//      
//        if (i < 15-3) 
//            {
//                if ( (pai[i] == pai[i + 1]) && (pai[i] == pai[i + 2])) //有三張一樣
//                    { 
//                        if (i == 14-3)
//                            {  
//                                hu[12-3] = hu[13-3] = hu[14-3] = pai[i];
//                                return true;
//                            }
//                            else if (jibenPutong2(i + 3, ydui))
//                                {
//                                    if(ydui)
//                                        {
//                                            hu[i-2] = hu[i-1] = hu[i] = pai[i];
//                                        }
//                                        else
//                                        {
//                                            hu[i] = hu[i+1] = hu[i+2] = pai[i];
//                                        }
//                                    return true;
//                                }
//                    }
//            }
//
//        if (pai[i] < 30) 
//		    {
//                int find1 = pai_firstPlace( pai, pai[i] + 1, i + 1, 16-3 );  //在牌中間搜索一個牌的第1次出現的位置，主要是判斷是不是順子
//                int find2 = pai_firstPlace( pai, pai[i] + 2, i + 1, 16-3 );
//                if ( (find1 != -1) && (find2 != -1)) //不是-1表示有找到
//				    {                 
//                        if (i ==14-3)
//						    {
//                                hu[12-3] = pai[i];
//                                hu[13-3] = pai[i]+1;
//                                hu[14-3] = pai[i]+2;
//                                return true;
//                            }
//							else
//							{
//                                pai[find1] = pai[i + 1];
//                                pai[i + 1] = pai[i] + 1;
//                                pai[find2] = pai[i + 2];
//                                pai[i + 2] = pai[i] + 2;
//                                if(jibenPutong2(i + 3, ydui))
//								    {
//                                        if(ydui)
//										    {
//                                                hu[i-2] = pai[i];
//                                                hu[i-1] = pai[i]+1;
//                                                hu[i] = pai[i]+2;
//                                            }
//											else
//											{
//                                                hu[i] = pai[i];
//                                                hu[i+1] = pai[i]+1;
//                                                hu[i+2] = pai[i]+2;
//                                            }
//                                        return true;
//                                    }
//                            }
//                    }
//            }
//        return false;
//    }
//	
//}
//
//
//
//
///////////////////////////////////////////////////////////////////////////////
////
////    Copyright (C) 2009 Joymaster Corporation. All Rights Reserved.
////
////////////////////////////////////////////////////////////////////////////////
