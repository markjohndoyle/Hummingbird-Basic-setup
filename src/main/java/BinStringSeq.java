public class BinStringSeq {


	public static void main(String[] args) {
		String packetStart = "0000000001100000000001000000000000000000000";

		for (int x = -179; x <= 0; x++) {
			String bin = Integer.toBinaryString(x);
			StringBuilder padded = new StringBuilder(16);
			if (bin.length() < 16) {
				int pad = 16 - bin.length();

				for (int i = 0; i < pad; i++) {
					padded.append("0");
				}

				padded.append(bin);
			}
			else if (bin.length() > 16) {
				padded.append(bin.substring(16));
			}
			else {
				padded.append(bin);
			}


			System.out.println(packetStart + padded);
		}

	}
}
