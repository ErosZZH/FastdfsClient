package net.mikesu.fastdfs.command;

import net.mikesu.fastdfs.data.Result;

import java.io.IOException;
import java.net.Socket;

public class ActiveTestCmd extends AbstractCmd<Boolean> {

	public ActiveTestCmd() {
		super();
		this.requestCmd = FDFS_PROTO_CMD_ACTIVE_TEST;
	}

	@Override
	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
        Response response = response(socket.getInputStream());
        if(response.isSuccess()) {
            return new Result<Boolean>(SUCCESS_CODE,true);
        }else {
            return new Result<Boolean>(response.getCode(),false);
        }
	}
}
