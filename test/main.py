# -*- coding: utf-8 -*-
import json
'''
接口需求：
实现对设备单位时间处理水量的统计，原始数据见附件一（由于开通数据库rds服务需要付费，鉴于数据量不大，可以考虑以json格式写死在代码中）
需要根据起始时间与结束时间，按照日或月的颗粒度统计处理水量（每日处理水量或每月处理水量），其中表格中原有数据为累计流量，
其中：单位时间处理水量 = 当前累计流量 – 上一个时间点累计流量。
入参：
设备id（如数值为0则返回全部设备）、起始时间（月-日的格式，文本，如12-01）、结束时间、时间颗粒度（日或月）
出参：
json格式，内容见下demo
[
    {
    "DeviceID":"LvXin_YT_001",
    "Date":"11-08",
    "value":0,
    "Column":"处理水量",
    "DateFormat":"日"
    }
]
'''

def main(deviceID, startDate, endDate, dateFormat):
    # 判断输入参数是否有误


    # 预处理数据
    start_month = int(startDate.split('-')[0])
    start_day = int(startDate.split('-')[1])
    end_month = int(endDate.split('-')[0])
    end_day = int(endDate.split('-')[1])
    if start_month == 1:
        start_month = 13
    elif start_month == 12 or start_month == 13:
        pass
    else:
        print("None date")
    if end_month == 1:
        end_month = 13
    elif end_month == 12 or end_month == 13:
        pass
    else:
        print("None date")

    # 将从json转为列表
    data_json = open("./data.json").read()
    data_list = json.loads(data_json)

    # 初始化数据列表
    data = []
    # 判断设备，提取相应的设备的数据进入自定义的数据列表中。
    if deviceID == 'A001':

        # 将设备A001的数据存入列表
        for i in range(0, 17):
            data.append(0)
        for i in range(0, 59):
            data.append(int(data_list[i]['累计流量']))
        value_monthly = (data[30]-data[16], data[61] - data[31], data[75]-data[62])
    elif deviceID == 'A002':
        # 将设备A002的数据存入列表
        for i in range(0, 17):
            data.append(0)
        for i in range(59, 118):
            data.append(int(data_list[i]['累计流量']))
        value_monthly = (data[30] - data[16], data[61] - data[31], data[75]-data[62])
    else:
        print('None Devices')

    # 初始化输出的列表
    output_list = []

    # 传出参数函数
    def output(device_ID, date, value, date_format):
        dir = {}
        dir["DeviceID"] = device_ID
        dir["Date"] = date
        dir["value"] = value
        dir["Column"] = "处理水量"
        if date_format == 'day':
            dir["DateFormat"] = "日"
        else:
            dir["DateFormat"] = "月"
        return dir

    # 根据时间颗粒度选取相应计算函数
    # 日颗粒度的计算函数
    if dateFormat == 'day':
        # start_num为起始值在data列表中的位置
        start_num = (start_month - 11) * 30 + start_day
        # lens为结束时间距离开始时间在列表中的偏移量
        lens = (end_month - start_month) * 30 + end_day - start_day
        for i in (start_num, start_num + lens + 1):
            month = i // 30
            day = i % 30
            date_current = str(month) + '-' + str(day)
            val = data[i] - data[i-1]
            output_list.append(output(deviceID, date_current, val, dateFormat))

    # 月颗粒度的计算函数
    elif dateFormat == 'month':
        for i in range(start_month - 11, start_month - end_month):
            date_current = str(i) + '-01'
            val = value_monthly[i]
            output_list.append(output(deviceID, date_current, val, dateFormat))
    else:
        print('None dateFormat')

    print(list(output_list))
    return output_list

# 传入参数
deviceID_input = input("请输入设备id（如数值为0则返回全部设备）")
startDate_input = input("起始时间（月-日的格式，文本，如12-01）")
endDate_input = input("结束时间")
dateFormat_input = input("时间颗粒度（日或月），请输入day或者month")

# 主程序入口
if __name__ == '__main__':
    # 提前判断参数
    try :

        res = []
        if type(deviceID_input) == str:
            res = main(deviceID_input, startDate_input, endDate_input, dateFormat_input)
        elif deviceID_input == '0':
            res = main('A001', startDate_input, endDate_input, dateFormat_input) + main('A002', startDate_input, endDate_input, dateFormat_input)
        else:
            print('None deviceID')

    except :
    main(deviceID_input, startDate_input, endDate_input, dateFormat_input)
