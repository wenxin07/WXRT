function YYYYMMDDstart() {
        MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        // 先給年下拉框賦內容   
        var y = new Date().getFullYear();
        for (var i = (y - 100); i < (y + 1); i++)
                document.reg_testdate.YYYY.options.add(new Option(" " + i, i));

        // 賦月份的下拉框   
        for (var i = 1; i < 13; i++)
                document.reg_testdate.MM.options.add(new Option(" " + i, i));

        document.reg_testdate.YYYY.value = y;
        document.reg_testdate.MM.value = new Date().getMonth() + 1;

        var n = MonHead[new Date().getMonth()];
        if (new Date().getMonth() == 1 && IsPinYear(YYYYvalue)) n++;
        writeDay(n); // 賦日期下拉框Author:meizz   
        document.reg_testdate.DD.value = new Date().getDate();
}

if (document.attachEvent)
        window.attachEvent("onload", YYYYMMDDstart);
else
        window.addEventListener('load', YYYYMMDDstart, false);

function YYYYDD(str) //年發生變化時日期發生變化(主要是判斷閏平年)   
{
        var MMvalue = document.reg_testdate.MM.options[document.reg_testdate.MM.selectedIndex].value;
        if (MMvalue == "") { var e = document.reg_testdate.DD; optionsClear(e); return; }
        var n = MonHead[MMvalue - 1];
        if (MMvalue == 2 && IsPinYear(str)) n++;
        writeDay(n)
}

function MMDD(str)   //月發生變化時日期聯動   
{
        var YYYYvalue = document.reg_testdate.YYYY.options[document.reg_testdate.YYYY.selectedIndex].value;
        if (YYYYvalue == "") { var e = document.reg_testdate.DD; optionsClear(e); return; }
        var n = MonHead[str - 1];
        if (str == 2 && IsPinYear(YYYYvalue)) n++;
        writeDay(n)
}

function writeDay(n)   //據條件寫日期的下拉框   
{
        var e = document.reg_testdate.DD; optionsClear(e);
        for (var i = 1; i < (n + 1); i++)
                e.options.add(new Option(" " + i, i));
}

function IsPinYear(year)//判斷是否閏平年   
{ return (0 == year % 4 && (year % 100 != 0 || year % 400 == 0)); }

function optionsClear(e) {
        e.options.length = 1;
}          
