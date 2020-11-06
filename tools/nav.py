import csv
import datetime
import json
import requests

"""
>>> formatstr='%d-%b-%Y'
>>> dtobj = datetime.datetime.strptime(datestr, formatstr)
>>> dtobj.date()
datetime.date(2020, 11, 4)
>>> print(dtobj.date())
"""

spdrgld_api_url = "http://localhost:8080/spdrgld"
date_format_str = '%d-%b-%Y'
column_names = ["date", "gldClosePrice", "lbmaGoldPrice", "navPerGldInGold",
        "navPerShare", "indicativePriceGld", "midpointSpread", "gldPremium",
        "dailyShareVolume", "navOunces", "navTonnes", "navUsd"]

def sendRow(row):
    #import pdb; pdb.set_trace()
    headers = {'Content-Type': 'application/json'}
    resp = requests.post(spdrgld_api_url, headers=headers,
            data=json.dumps(row))
    print(resp)

if __name__ == '__main__':
    print("I am starting up")
    with open('GLD_US_archive_EN.csv', 'r') as csv_file:
        reader = csv.DictReader(csv_file, fieldnames=column_names, skipinitialspace=True)

        # Discard header rows
        for n in range(7):
            next(reader)

        for row in reader:
            # Skip useless rows.
            if row["gldClosePrice"] == "HOLIDAY":
                continue
            if row["gldClosePrice"] == "AWAITED":
                continue
            if row["dailyShareVolume"] == "NYSE Closed":
                continue

            # Sanitize
            # Convert date
            datestr = row["date"]
            dtobj = datetime.datetime.strptime(datestr, date_format_str)
            row["date"] = dtobj.strftime("%Y-%m-%d")

            row["lbmaGoldPrice"] = row["lbmaGoldPrice"].lstrip('$')
            row["midpointSpread"] = row["midpointSpread"].lstrip('$')
            row["gldPremium"] = row["gldPremium"].rstrip('%')
            row["dailyShareVolume"] = int(row["dailyShareVolume"])

            print(json.dumps(row, indent=4))
            sendRow(row)
