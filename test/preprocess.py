# -*- coding: utf-8 -*-

def settings(deviceID_input, startDate_input, endDate_input, dateFormat_input):
    try :
        while True :
            if type(deviceID_input) == str and len(deviceID_input) < 6:
                continue
            else:
                print('None deviceID')
                break
        while True :
            if type(startDate_input) == str and len(deviceID_input) < 6:
                continue
            else:
                print('None startDate')
                break
        while True :
            if type(endDate_input) == str and len(deviceID_input) < 6:
                continue
            else:
                print('None endDate')
                break
        while True :
            if type(dateFormat_input) == str and len(deviceID_input) < 2:
                continue
            else:
                print('None endDate')
                break

        res = []
        if type(deviceID_input) == str:
            res = main(deviceID_input, startDate_input, endDate_input, dateFormat_input)
        elif deviceID_input == '0':
            res = main('A001', startDate_input, endDate_input, dateFormat_input) + main('A002', startDate_input, endDate_input, dateFormat_input)
        else:
            print('None deviceID')

    except :