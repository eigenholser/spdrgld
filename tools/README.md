# SPDR GLD NAV Report

This is a quick and dirty parser and client for the Spring Boot server.

Fetch the daily report like this:

    wget www.spdrgoldshares.com/assets/dynamic/GLD/GLD_US_archive_EN.csv

Make a virtual environment:

    mkvirtualenv --python python3 spdrgld

Install the only Python dependency you'll ever need:

    pip install requests

Run it:

    python nav.py
