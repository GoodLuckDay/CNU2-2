#!/usr/bin/python

import os
from subprocess import *

run = lambda cmd: check_output(cmd, shell=True, executable='/bin/bash')

if __name__ == '__main__':
	who = run('whoami')
	
	message = '''%s'''% (who)
	f = open('./account', 'w+')
	f.writelines(message)

	f.close()
